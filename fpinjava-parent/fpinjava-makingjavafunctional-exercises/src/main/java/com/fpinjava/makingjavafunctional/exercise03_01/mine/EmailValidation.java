package com.fpinjava.makingjavafunctional.exercise03_01.mine;

import com.fpinjava.common.Function;

import java.util.regex.Pattern;

public class EmailValidation {

    private static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static Function<String, Result<String>> emailChecker(Effect<String> onSuccess, Effect<String> onFailure) {
        return s -> s == null ?
                new Result.Failure<>("email must not be null", onFailure)
                : s.length() == 0
                ? new Result.Failure<>("email must not be empty", onFailure)
                : emailPattern.matcher(s).matches()
                ? new Result.Success<>(onSucess)
                : new Result.Failure<>("email " + s + " is invalid.", onFailure);
    }


    public static void main(String... args) {
        validate("this.is@my.email").resultEffect().invoke();
        validate(null).resultEffect();
        validate("").exec();
        validate("john.doe@acme.com").exec();
    }

    private static void logError(String s) {
        System.err.println("Error message logged: " + s);
    }

    private static void sendVerificationMail(String s) {
        System.out.println("Mail sent to " + s);
    }

    static Result<String> validate(String s) {
        return emailChecker(EmailValidation::sendVerificationMail, EmailValidation::logError).apply(s);
    }
}
package com.fpinjava.makingjavafunctional.exercise03_01.mine;

public interface Result<T> {

    Effect<T> resultEffect();

    abstract class ResultBase<T> implements Result<T> {
        private final Effect<T> effect;

        public ResultBase(Effect<T> effect) {
            this.effect = effect;
        }

        @Override
        public Effect<T> resultEffect() {
            return effect;
        }
    }

    class Success<T> extends ResultBase<T> {
        public Success(Effect<T> effect) {
            super(effect);
        }
    }

    class Failure<T> extends ResultBase<T> {
        private final String errorMessage;

        public Failure(String message, Effect<T> onFailure) {
            super(onFailure);
            errorMessage = message;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}

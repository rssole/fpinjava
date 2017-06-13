package com.fpinjava.makingjavafunctional.exercise03_06;

import com.fpinjava.common.Function;
import org.junit.Test;

import java.util.List;


import static com.fpinjava.makingjavafunctional.exercise03_04.CollectionUtilities.list;
import static com.fpinjava.makingjavafunctional.exercise03_06.MyCollectionUtilities.foldLeft;
import static org.assertj.core.api.Assertions.assertThat;


public class MyCollectionUtilitiesTest {
    @Test
    public void foldLeftShouldBehaveAsExpected() throws Exception {
        List<Integer> list = list(1, 2, 3, 4, 5);
        String identity = "0";
        Function<String, Function<Integer, String>> f = x -> y -> addSI(x, y);


        final String outcome = foldLeft(list, identity, f);

        assertThat(outcome).describedAs("It should have folded left properly :)")
                .isEqualTo("(((((0 + 1) + 2) + 3) + 4) + 5)");
    }

    private String addSI(String s, Integer i) {
        return "(" + s + " + " + i + ")";
    }
}

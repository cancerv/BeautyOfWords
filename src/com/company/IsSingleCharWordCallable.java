package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class IsSingleCharWordCallable extends AbstractWordCheckerCallable {
    IsSingleCharWordCallable(
            AtomicInteger countOfThree,
            AtomicInteger countOfFour,
            AtomicInteger countOfFive,
            String[] words
    ) {
        super(countOfThree, countOfFour, countOfFive, words);
    }

    @Override
    protected boolean check(String word) {
        char first = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (first != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

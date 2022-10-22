package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class IsAscendingWordCallable extends AbstractWordCheckerCallable {
    IsAscendingWordCallable(
            AtomicInteger countOfThree,
            AtomicInteger countOfFour,
            AtomicInteger countOfFive,
            String[] words
    ) {
        super(countOfThree, countOfFour, countOfFive, words);
    }

    @Override
    protected boolean check(String word) {
        char currentChar = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (currentChar > word.charAt(i)) {
                return false;
            } else {
                currentChar = word.charAt(i);
            }
        }
        return true;
    }
}

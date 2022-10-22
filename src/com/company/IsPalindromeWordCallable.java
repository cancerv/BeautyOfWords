package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class IsPalindromeWordCallable extends AbstractWordCheckerCallable {
    IsPalindromeWordCallable(
            AtomicInteger countOfThree,
            AtomicInteger countOfFour,
            AtomicInteger countOfFive,
            String[] words
    ) {
        super(countOfThree, countOfFour, countOfFive, words);
    }

    @Override
    protected boolean check(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class IsAscendingWordCallable implements Callable<Integer> {
    private final AtomicInteger countOfThree;
    private final AtomicInteger countOfFour;
    private final AtomicInteger countOfFive;
    private final String[] words;

    IsAscendingWordCallable(
            AtomicInteger countOfThree,
            AtomicInteger countOfFour,
            AtomicInteger countOfFive,
            String[] words
    ) {
        this.countOfThree = countOfThree;
        this.countOfFour = countOfFour;
        this.countOfFive = countOfFive;
        this.words = words;
    }

    @Override
    public Integer call() {
        for (String word : this.words) {
            if (this.isAscendingWord(word)) {
                switch (word.length()) {
                    case 3 -> countOfThree.incrementAndGet();
                    case 4 -> countOfFour.incrementAndGet();
                    case 5 -> countOfFive.incrementAndGet();
                }
            }
        }
        return null;
    }

    private boolean isAscendingWord(String word) {
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

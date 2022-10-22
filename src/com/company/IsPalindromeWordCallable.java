package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class IsPalindromeWordCallable implements Callable<Integer> {
    private final AtomicInteger countOfThree;
    private final AtomicInteger countOfFour;
    private final AtomicInteger countOfFive;
    private final String[] words;

    IsPalindromeWordCallable(
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
            if (this.isPalindromeWord(word)) {
                switch (word.length()) {
                    case 3 -> countOfThree.incrementAndGet();
                    case 4 -> countOfFour.incrementAndGet();
                    case 5 -> countOfFive.incrementAndGet();
                }
            }
        }
        return null;
    }

    private boolean isPalindromeWord(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

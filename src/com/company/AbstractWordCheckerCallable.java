package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractWordCheckerCallable implements Callable<Integer> {
    private final AtomicInteger countOfThree;
    private final AtomicInteger countOfFour;
    private final AtomicInteger countOfFive;
    private final String[] words;

    AbstractWordCheckerCallable(
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
            if (this.check(word)) {
                switch (word.length()) {
                    case 3 -> countOfThree.incrementAndGet();
                    case 4 -> countOfFour.incrementAndGet();
                    case 5 -> countOfFive.incrementAndGet();
                }
            }
        }
        return null;
    }

    abstract protected boolean check(String word);
}

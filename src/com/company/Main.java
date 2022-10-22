package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] words = new String[100_000];
        for (int i = 0; i < words.length; i++) {
            words[i] = generateText("abc", 3 + random.nextInt(3));
        }

        AtomicInteger countOfThree = new AtomicInteger(0);
        AtomicInteger countOfFour = new AtomicInteger(0);
        AtomicInteger countOfFive = new AtomicInteger(0);

        List<Callable<Integer>> callables = Arrays.asList(
                new IsAscendingWordCallable(countOfThree, countOfFour, countOfFive, words),
                new IsPalindromeWordCallable(countOfThree, countOfFour, countOfFive, words),
                new IsSingleCharWordCallable(countOfThree, countOfFour, countOfFive, words)
        );

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        threadPool.invokeAll(callables);

        System.out.println("Красивых слов с длиной 3: " + countOfThree.get());
        System.out.println("Красивых слов с длиной 4: " + countOfFour.get());
        System.out.println("Красивых слов с длиной 5: " + countOfFive.get());

        threadPool.shutdown();
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}

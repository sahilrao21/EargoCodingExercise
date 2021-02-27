package main;
import test.TestCoinChange;
import java.util.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CoinChange {
    public static int[] denominations = new int[]{1, 5, 10, 25};

    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        Result result = junit.runClasses(TestCoinChange.class);

        System.out.printf("%nSUMMARY:%n# of tests run: %d%n# of tests failed: %d%n",
                result.getRunCount(), result.getFailureCount());

        for (Failure failure : result.getFailures()) {
            System.out.print("\n" + failure.toString());
        }
    }

    // Assumes Assumes denomination array is sorted in ascending order and an answer exists
    public static Map<Integer, Integer> calculateChangeGreedy(int cents) {
        // Initializing coin change map to return
        Map<Integer, Integer> numCoinsMap = initializeCoinMap();

        // Base case
        if (cents < 1) {
            return numCoinsMap;
        }

        // Calculating number of each coin used.
        int denomIndex = denominations.length - 1;
        int currDenom = denominations[denomIndex];

        while (cents > 0) {
            int numUsed = cents / currDenom;
            if (numUsed != 0) {
                numCoinsMap.put(currDenom, numCoinsMap.get(currDenom) + numUsed);
            }
            cents = cents % currDenom;
            currDenom = (denomIndex != 0) ? denominations[--denomIndex] : denominations[0];
        }

        return numCoinsMap;
    }

    // assumes an answer exists
    public static Map<Integer, Integer> calculateMinChange(int cents) {
        // Initializing coin change map to return
        Map<Integer, Integer> numCoinsMap = initializeCoinMap();

        // Base case
        if (cents < 1) {
            return numCoinsMap;
        }

        // Initializing DP arrays
        int[] minCoins = new int[cents + 1];
        int[] parents = new int[cents + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        Arrays.fill(parents, Integer.MAX_VALUE);
        minCoins[0] = 0;
        parents[0] = 0;

        // Calculating minimum number of coins and storing parents
        for (int i = 1; i < minCoins.length; i++) {
            for (int d : denominations) {
                if (i - d >= 0 && minCoins[i - d] != Integer.MAX_VALUE && minCoins[i - d] < minCoins[i] - 1) {
                    minCoins[i] = minCoins[i - d] + 1;
                    parents[i] = i - d;
                }
            }
        }

        // Traversing through parent array to find amount of each coin used
        int amountLeft = cents;
        while (amountLeft > 0) {
            int coinUsed = amountLeft - parents[amountLeft];
            numCoinsMap.put(coinUsed, numCoinsMap.get(coinUsed) + 1);
            amountLeft = parents[amountLeft];
        }

        return numCoinsMap;
    }

    public static Map<Integer, Integer> initializeCoinMap() {
        Map<Integer, Integer> numCoinsMap = new HashMap<>();
        for (int d : denominations) {
            numCoinsMap.put(d, 0);
        }

        return numCoinsMap;
    }
}
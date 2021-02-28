package test;
import main.CoinChange;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestCoinChange {
    @Test
    public void testGreedy1() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 0;

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, true);
    }

    @Test
    public void testGreedy2() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 35;

        correctMap.put(10, 1);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, true);
    }

    @Test
    public void testGreedy3() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 27;

        correctMap.put(1, 2);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, true);
    }

    @Test
    public void testGreedy4() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 30;

        correctMap.put(5, 1);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, true);
    }

    @Test
    public void testGreedy5() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 83;

        correctMap.put(1, 3);
        correctMap.put(5, 1);
        correctMap.put(25, 3);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, true);
    }

    @Test
    public void testGreedy6() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 165;

        correctMap.put(5, 1);
        correctMap.put(10, 1);
        correctMap.put(25, 6);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, true);
    }

    @Test
    public void testGreedy7() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 179;

        correctMap.put(1, 4);
        correctMap.put(25, 7);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, true);
    }

    @Test
    public void testDP1() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 0;

        Map<Integer, Integer> retMap = CoinChange.calculateMinChange(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, false);
    }

    @Test
    public void testDP2() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 35;

        correctMap.put(10, 1);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateMinChange(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, false);
    }

    @Test
    public void testDP3() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 27;

        correctMap.put(1, 2);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateMinChange(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, false);
    }

    @Test
    public void testDP4() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 30;

        correctMap.put(5, 1);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateMinChange(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, false);
    }

    @Test
    public void testDP5() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 83;

        correctMap.put(1, 3);
        correctMap.put(5, 1);
        correctMap.put(25, 3);

        Map<Integer, Integer> retMap = CoinChange.calculateMinChange(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, false);
    }

    @Test
    public void testDP6() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 165;

        correctMap.put(5, 1);
        correctMap.put(10, 1);
        correctMap.put(25, 6);

        Map<Integer, Integer> retMap = CoinChange.calculateMinChange(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, false);
    }

    @Test
    public void testDP7() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 179;

        correctMap.put(1, 4);
        correctMap.put(25, 7);

        Map<Integer, Integer> retMap = CoinChange.calculateMinChange(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap, false);
    }

    public void printNumCoins(int cents, Map<Integer, Integer> numCoinsMap, boolean isGreedy) {
        System.out.printf("%nFor an amount of %d cent(s), the %s solution will return:%n",
                cents, (isGreedy) ? "greedy" : "DP");

        for (int d : CoinChange.denominations) {
            System.out.printf("%d, %d cent coin(s)%n", numCoinsMap.get(d), d);
        }
    }
}

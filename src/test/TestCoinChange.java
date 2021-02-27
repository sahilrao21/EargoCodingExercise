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

        printNumCoins(cents, retMap);
    }

    @Test
    public void testGreedy2() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 35;

        correctMap.put(10, 1);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap);
    }

    @Test
    public void testGreedy3() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 27;

        correctMap.put(1, 2);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap);
    }

    @Test
    public void testGreedy4() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 30;

        correctMap.put(5, 1);
        correctMap.put(25, 1);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap);
    }

    @Test
    public void testGreedy5() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 125;

        correctMap.put(25, 5);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap);
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

        printNumCoins(cents, retMap);
    }

    @Test
    public void testGreedy7() {
        Map<Integer, Integer> correctMap = CoinChange.initializeCoinMap();
        int cents = 179;

        correctMap.put(1, 4);
        correctMap.put(25, 7);

        Map<Integer, Integer> retMap = CoinChange.calculateChangeGreedy(cents);
        assertTrue(retMap.equals(correctMap));

        printNumCoins(cents, retMap);
    }

    public void printNumCoins(int cents, Map<Integer, Integer> numCoinsMap) {
        System.out.printf("%nFor an amount of %d cent(s), you will be given:%n", cents);
        for (int d : CoinChange.denominations) {
            System.out.printf("%d, %d cent coin(s)%n", numCoinsMap.get(d), d);
        }
    }
}

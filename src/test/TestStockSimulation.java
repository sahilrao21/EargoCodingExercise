package test;
import main.StockSimulation;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestStockSimulation {
    @Test
    public void testMaximizeOneTrade1() {
        double[] prices = new double[0];
        int[] correctDayPairs = new int[0];

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeOneTrade2() {
        double[] prices = new double[]{3, 8, 8, 55, 38, 1, 7, 42, 54, 53};
        int[] correctDayPairs = new int[]{5, 8};

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeOneTrade3() {
        double[] prices = new double[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 2};
        int[] correctDayPairs = new int[]{0, 5};

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeOneTrade4() {
        double[] prices = new double[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
        int[] correctDayPairs = new int[]{0, 4};

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeOneTrade5() {
        double[] prices = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 0, 9};
        int[] correctDayPairs = new int[]{8, 9};

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeOneTrade6() {
        double[] prices = new double[]{1, 6, 4.7, 9.8, 9.99, 0.8, 9.8, 0.7, 0.4, 4};
        int[] correctDayPairs = new int[]{5, 6};

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeOneTrade7() {
        double[] prices = new double[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] correctDayPairs = new int[0];

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeOneTrade8() {
        double[] prices = new double[]{3, 8, 8, 56, 38, 2, 7, 42, 54, 53};
        int[] correctDayPairs = new int[]{0, 3};

        int[] retDayPairs = StockSimulation.maximizeOneTrade(prices);
        assertTrue(Arrays.equals(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, Arrays.asList(retDayPairs), false);
    }

    @Test
    public void testMaximizeMultipleTrades1() {
        double[] prices = new double[0];
        List<int[]> correctDayPairs = new ArrayList<>();

        List<int[]> retDayPairs = StockSimulation.maximizeMultipleTrades(prices);
        assertTrue(areDayPairsEqual(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, retDayPairs, true);
    }

    @Test
    public void testMaximizeMultipleTrades2() {
        double[] prices = new double[]{3, 8, 8, 55, 38, 1, 7, 42, 54, 53};
        List<int[]> correctDayPairs = new ArrayList<>();

        /* NOTE: The code only sell a stock once its price strictly decreases. Therefore,
         * we will not sell on day 1 and re-buy on day 2. If the code is modified
         * to sell on non-increasing prices, the correct pairs in this test case and
         * other similar ones will need to be tweaked.
         */
        correctDayPairs.add(new int[]{0, 3});
        correctDayPairs.add(new int[]{5, 8});

        List<int[]> retDayPairs = StockSimulation.maximizeMultipleTrades(prices);
        assertTrue(areDayPairsEqual(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, retDayPairs, true);
    }

    @Test
    public void testMaximizeMultipleTrades3() {
        double[] prices = new double[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 2};
        List<int[]> correctDayPairs = new ArrayList<>();
        correctDayPairs.add(new int[]{0, 5});

        List<int[]> retDayPairs = StockSimulation.maximizeMultipleTrades(prices);
        assertTrue(areDayPairsEqual(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, retDayPairs, true);
    }

    @Test
    public void testMaximizeMultipleTrades4() {
        double[] prices = new double[]{0, 7, 3, 4, 5, 4, 3, 4.1, 4.05, 2};
        List<int[]> correctDayPairs = new ArrayList<>();
        correctDayPairs.add(new int[]{0, 1});
        correctDayPairs.add(new int[]{2, 4});
        correctDayPairs.add(new int[]{6, 7});

        List<int[]> retDayPairs = StockSimulation.maximizeMultipleTrades(prices);
        assertTrue(areDayPairsEqual(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, retDayPairs, true);
    }

    @Test
    public void testMaximizeMultipleTrades5() {
        double[] prices = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 0, 9};
        List<int[]> correctDayPairs = new ArrayList<>();
        correctDayPairs.add(new int[]{0, 7});
        correctDayPairs.add(new int[]{8, 9});

        List<int[]> retDayPairs = StockSimulation.maximizeMultipleTrades(prices);
        assertTrue(areDayPairsEqual(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, retDayPairs, true);
    }

    @Test
    public void testMaximizeMultipleTrades6() {
        double[] prices = new double[]{1, 6, 4.7, 9.8, 12.3, 0.8, 9.8, 0.7, 0.4, 4};
        List<int[]> correctDayPairs = new ArrayList<>();
        correctDayPairs.add(new int[]{0, 1});
        correctDayPairs.add(new int[]{2, 4});
        correctDayPairs.add(new int[]{5, 6});
        correctDayPairs.add(new int[]{8, 9});

        List<int[]> retDayPairs = StockSimulation.maximizeMultipleTrades(prices);
        assertTrue(areDayPairsEqual(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, retDayPairs, true);
    }

    @Test
    public void testMaximizeMultipleTrades7() {
        double[] prices = new double[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        List<int[]> correctDayPairs = new ArrayList<>();

        List<int[]> retDayPairs = StockSimulation.maximizeMultipleTrades(prices);
        assertTrue(areDayPairsEqual(correctDayPairs, retDayPairs));
        printTransactionInfo(prices, retDayPairs, true);
    }

    public static boolean areDayPairsEqual(List<int[]> pairs1, List<int[]> pairs2) {
        if (pairs1.size() != pairs1.size()) {
            return false;
        }

        for (int i = 0; i < pairs1.size(); i++) {
            if (!Arrays.equals(pairs1.get(i), pairs2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public void printTransactionInfo(double[] prices, List<int[]> dayPairs, boolean multipleAllowed) {
        System.out.printf("%nTo maximize profit with stock prices of %s using %s transaction(s):%n",
                Arrays.toString(prices), (multipleAllowed) ? "any number of" : "at most one");

        if (dayPairs.size() == 0 || dayPairs.get(0).length == 0) {
            System.out.println("Do not buy this stock.");
            return;
        }

        for (int[] p : dayPairs) {
            System.out.printf("Buy on day %d, Sell on day %d%n", p[0], p[1]);
        }
    }
}


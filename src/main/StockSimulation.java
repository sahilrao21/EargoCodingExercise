package main;
import test.TestStockSimulation;

import java.util.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class StockSimulation {
    public static void main(String[] args) {
        // Runs all JUnit tests in the TestStockSimulation class
        JUnitCore junit = new JUnitCore();
        Result result = junit.runClasses(TestStockSimulation.class);

        // Prints statistics about the tests, as well as info about failed tests
        System.out.printf("%nSUMMARY:%n# of tests run: %d%n# of tests failed: %d%n",
                result.getRunCount(), result.getFailureCount());

        for (Failure failure : result.getFailures()) {
            System.out.print("\n" + failure.toString());
        }
    }

    /**
     * Given a list of stock prices over multiple days, calculates the best transaction
     * in order to maximize profit. At most one transaction is allowed. When it is not possible
     * to generate a positive transaction, the function returns an empty, zero-length array.
     *
     * @param prices the price of the stock each day
     * @return int array with two elements. The first element in the array represents the
     * day to buy a stock, and the second element in the array represents the day to sell
     * the corresponding stock to maximize profit.
     */
    public static int[] maximizeOneTrade(double[] prices) {
        // Base case
        if (prices == null || prices.length < 2) {
            return new int[0];
        }

        // Initializing variables about global and local maximum profit
        int[] bestDayPair = new int[2];
        int[] currDayPair = new int[2];
        double maxProfit = 0;
        double currProfit = 0;

        /*
         * Iterates over stock prices. When a higher sell price found, updates local maximum info.
         * When a lower buy price found, checks if global < local maximum before re-assigning local vars
         */
        for (int i = 1; i < prices.length; i++) {
            if (prices[currDayPair[0]] <= prices[i] && prices[currDayPair[1]] < prices[i]) {
                currDayPair[1] = i;
                currProfit = prices[currDayPair[1]] - prices[currDayPair[0]];
            }
            else if (prices[currDayPair[0]] > prices[i]) {
                if (maxProfit < currProfit) {
                    bestDayPair[0] = currDayPair[0];
                    bestDayPair[1] = currDayPair[1];
                    maxProfit = currProfit;
                }
                currDayPair[0] = i;
                currDayPair[1] = i;
                currProfit = 0;
            }
        }

        // Checks if the last segment of stock prices provide the maximum
        if (maxProfit < currProfit) {
            bestDayPair[0] = currDayPair[0];
            bestDayPair[1] = currDayPair[1];
        }

        // Returns pair of days that maximize profit, or empty array if no profit is possible
        return (bestDayPair[0] != bestDayPair[1]) ? bestDayPair : new int[0];
    }

    /**
     * Given a list of stock prices over multiple days, calculates the best transactions
     * in order to maximize profits. Transactions are specified by a buy day and sell day.
     * The function does not allow buying and selling on the same day. When it is not possible
     * to generate a positive transaction, the function returns an empty list.
     *
     * TESTING NOTE: the code revolves around finding days where the stock price decreases. For
     * days i and (i + 1) where the stock price stays the same, the stock is not sold and re-bought.
     * While it would be ok to sell the stock on day i and re-buy it on day (i + 1), this does not
     * match the output format of the code. Therefore, make sure you follow this output format
     * when testing or else it will fail.
     *
     * @param prices the price of the stock each day
     * @return list of two-element arrays. The first element in the array represents the
     * day to buy a stock, and the second element in the array represents the day to sell
     * the corresponding stock to maximize profit.
     */
    public static List<int[]> maximizeMultipleTrades(double[] prices) {
        List<int[]> bestDayPairs = new ArrayList<>();

        // Base case
        if (prices == null || prices.length < 2) {
            return bestDayPairs;
        }

        /*
         * Iterates over stock prices. When the stock price strictly decreases on some day i, we sell our stock
         * on day (i - 1), and buy a new stock on day i
         */
        int[] currDayPair = new int[2];
        for (int i = 1; i < prices.length; i++) {
            if (prices[currDayPair[1]] <= prices[i]) {
                currDayPair[1] = i;
            }
            else {
                if (prices[currDayPair[1]] - prices[currDayPair[0]] != 0) {
                    bestDayPairs.add(currDayPair);
                }
                currDayPair = new int[]{i, i};
            }
        }

        // Checks if the last segment of stock prices would give additional profit
        if (prices[currDayPair[1]] - prices[currDayPair[0]] != 0) {
            bestDayPairs.add(currDayPair);
        }

        return bestDayPairs;
    }
}

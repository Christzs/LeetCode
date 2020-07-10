package com.leetcode.problem.medium;

/**
 * @author zst
 * @date 2020-07-10
 */
public class p309_BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        // dp[i][0] 手中持有股票的最大收益
        // dp[i][1] 手中不持有股票且处于冷冻期的最大收益
        // dp[i][2]  手中不持有股票且不处于冷冻期的最大收益
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[len -1][1], dp[len -1][2]);
    }

}

package com.leetcode.problem.interview;

/**
 * 08.11. Coin LCCI
 *
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent), write code to calculate the number of ways of representing n cents. 
 * (The result may be large, so you should return it modulo 1000000007)
 *
 * Example1:
 *
 *  Input: n = 5
 *  Output: 2
 *  Explanation: There are two ways:
 * 5=5
 * 5=1+1+1+1+1
 *
 */
public class p08_11_CoinLCCI {

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10 ,25};

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

}

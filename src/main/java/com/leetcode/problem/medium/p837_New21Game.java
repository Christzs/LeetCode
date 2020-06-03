package com.leetcode.problem.medium;

/**
 * 837. New 21 Game
 * Alice plays the following game, loosely based on the card game "21".
 *
 * Alice starts with 0 points, and draws numbers while she has less than K points.
 * During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.
 * Each draw is independent and the outcomes have equal probabilities.
 *
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 *
 * Example 1:
 *
 * Input: N = 10, K = 1, W = 10
 * Output: 1.00000
 * Explanation:  Alice gets a single card, then stops.
 * Example 2:
 *
 * Input: N = 6, K = 1, W = 10
 * Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * Example 3:
 *
 * Input: N = 21, K = 17, W = 10
 * Output: 0.73278
 */
public class p837_New21Game {

    public double new21Game(int N, int K, int W) {

        if (K == 0) {
            return 1.0;
        }

        double[] dp = new double[K + W + 1];
        // 初始化dp数组
        // 对于当前分数x，如果K <= x <= min(N, K + W - 1) 则dp[x] = 1.0
        // 如果 x > min(N, K + W - 1) 则表示分数大于n或无法达到该分数
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }

        // dp[x] = (dp[x + 1] + dp[x + 2] + ... + dp[x + W]) / W
        // 计算dp相邻数值，dp[x] - dp[x + 1] = (dp[x + 1] - dp[x + W + 1]) / W
        // 则 dp[x] = dp[x + 1] - (dp[x + W + 1] - dp[x + 1]) / W
        // 当x = K - 1时，上述规则不适用
        // dp[K - 1] = (dp[K] + dp[K + 1] + ... + dp[K - 1 + W]) / W
        // 由于K <= x <= min(N, K + W - 1)时，dp[x] = 1
        // 故有，dp[x] = (min(N, K + W - 1) - (K - 1)) / W = min(N - K + 1, W) / W
        dp[K - 1] = 1.0 *  Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }


}

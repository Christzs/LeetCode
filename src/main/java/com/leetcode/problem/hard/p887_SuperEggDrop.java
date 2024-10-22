package com.leetcode.problem.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/super-egg-drop/description/
 *
 * 887. 鸡蛋掉落
 *
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 * 示例 1：
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 *
 * 示例 2：
 * 输入：k = 2, n = 6
 * 输出：3
 *
 * 示例 3：
 * 输入：k = 3, n = 14
 * 输出：4
 *
 * 提示：1 <= k <= 100; 1 <= n <= 10^4
 */
public class p887_SuperEggDrop {

    private static final Map<Integer, Integer> MEMO = new HashMap<>();

    /**
     * @param k, 1 <= k <= 100
     * @param n, 1 <= n <= 104
     * @return f
     */
    public int superEggDrop(int k, int n) {
        return search(k, n);
    }

    private int search(int k, int n) {
        // k个鸡蛋 n层楼
        if (MEMO.containsKey(getMemoKey(k, n))) {
            return MEMO.get(getMemoKey(k, n));
        }
        int res = Integer.MAX_VALUE;
        if (k == 1) {
            // 剩余1个egg, 逐层遍历
            res = n;
        } else if (k == 0 || n == 0) {
            // 无法继续操作
            res = 0;
        } else {
            int low = 1;
            int high = n;
            while (low + 1 < high) {
                int mid = (low + high) / 2;
                // 鸡蛋碎了, 向下搜索
                int left = search(k - 1, mid - 1);
                // 鸡蛋没碎, 向上搜索
                int right = search(k, n - mid);
                if (left < right) {
                    // 高层更大，去搜索更大的范围
                    low = mid;
                } else if (right < left) {
                    // 低层更大，去搜索更小的范围
                    high = mid;
                } else {
                    // 左右层一样大，退出
                    low = high = mid;
                }
            }
            // 高低层搜索结果的最大值中的最小值，即在搜索的最坏结果中，取最小值
            res = 1 + Math.min(
                    Math.max(search(k - 1, low - 1), search(k, n - low)),
                    Math.max(search(k - 1, high - 1), search(k, n - high)));
        }
        MEMO.put(getMemoKey(k, n), res);
        return res;
    }

    private int getMemoKey(int k, int n) {
        return n * 1000 + k;
    }

    public static void main(String[] args) {
        p887_SuperEggDrop solution = new p887_SuperEggDrop();
        System.out.println(solution.superEggDrop(4, 10000));
    }

}

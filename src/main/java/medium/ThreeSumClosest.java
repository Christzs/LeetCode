package medium;

import java.util.Arrays;

/**
 *
 * 16 3Sum Closest
 *
 * Given an array nums of n integers and an integer target
 *
 * find three integers in nums such that the sum is closest to target
 *
 * Return the sum of the three integers
 *
 * (You may assume that each input would have exactly one solution)
 *
 * Input: [-1, 2, 1, -4], 1
 *
 * Output: (-1 + 2 + 1) = 2
 *
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length, res = Integer.MIN_VALUE;

        if (len < 3) {
            return 0;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {

            int num = nums[i];

            int left = i + 1, right = len - 1;

            while (left < right && right < len) {
                int sum = num + nums[left] + nums[right];
                res = getCloserNum(sum, res, target);
                if (sum == target) {
                    return target;
                }
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
            }

        }

        return res;
    }

    private int getCloserNum(int a, int res, int target) {
        if (res == Integer.MIN_VALUE) {
            return a;
        }
        if (Math.abs(target - a) > Math.abs(target - res)) {
            return res;
        }
        return a;
    }
}

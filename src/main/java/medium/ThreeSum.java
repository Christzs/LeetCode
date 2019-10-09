package medium;

import java.util.*;

/**
 * @Description
 *
 * 14 3Sum
 *
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 *
 * Find all unique triplets in the array which gives the sum of zero
 *
 *
 * Input: [-1, 0, 1, 2, -1, -4]
 *
 * Output:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len < 3 || nums == null) {
            return res;
        }

        Arrays.sort(nums);

        for (int index = 0; index < len - 2; index++) {
            // 跳过重复数字
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            if (nums[index] > 0) {
                break;
            }
            int findSum = 0 - nums[index];
            int left = index + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == findSum) {
                    res.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    // 跳过重复数字
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    // 跳过重复数字
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    left++;
                    right--;
                } else if (sum < findSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res.toString());
    }


}

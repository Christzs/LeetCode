package com.leetcode.problem.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 * Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
 *
 * For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them.
 *
 * Notice that multiple kids can have the greatest number of candies.
 *
 *
 *
 * Example 1:
 *
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 */
public class p1431_KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int size = candies.length;

        if (size == 0) {
            return new ArrayList<>();
        }

        List<Boolean> res = new ArrayList<>();

        int max = -1;

        for (int n : candies) {
            max = Math.max(n, max);
        }

        for (int n : candies) {
            if (n + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;

    }
}

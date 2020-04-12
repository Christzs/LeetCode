package com.leetcode.problem.hard;

/**
 * 16.03. Intersection LCCI
 *
 * Given two straight line segments (represented as a start point and an end point), compute the point of intersection, if any.
 * If there's no intersection, return an empty array.
 *
 * The absolute error should not exceed 10^-6. If there are more than one intersections, return the one with smallest X axis value.
 * If there are more than one intersections that have same X axis value, return the one with smallest Y axis value.
 *
 * Input:
 *  line1 = {0, 0}, {1, 0}
 *  line2 = {1, 1}, {0, -1}
 * Output:
 *  {0.5, 0}
 */
public class _16_03_IntersectionLCCI {

    /**
     * y = a1x + b1
     * y = a2x + b2
     */
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double a1, a2;
        if (end1[0] - start1[0] != 0) {
            a1 = (double)(end1[1] - start1[1]) / (end1[0] - start1[0]);
        } else {
            a1 = Double.MIN_VALUE;
        }
        if (end2[0] - start2[0] != 0) {
            a2 = (double)(end2[1] - start2[1]) / (end2[0] - start2[0]);
        } else {
            a2 = Double.MIN_VALUE;
        }

        if (a1 == Double.MIN_VALUE && a2 == Double.MIN_VALUE) {
            if (start1[0] != start2[0]) {
                return empty();
            }
            int y = getMinRange(new int[]{start1[1], end1[1]}, new int[]{start2[1], end2[1]});
            return y < 0 ? empty() : new double[]{start1[0], y};
        }

        double b1, b2, x, y;
        if (a1 == Double.MIN_VALUE) {
            x = start1[0];
            b2 = start2[1] - a2 * start2[0];
            if (!check(x, start2, end2)) {
                return empty();
            }
            return new double[] {x, a2 * x + b2};
        }

        if (a2 == Double.MIN_VALUE) {
            x = start2[0];
            b1 = start1[1] - a2 * start1[0];
            if (!check(x, start1, end1)) {
                return empty();
            }
            return new double[] {x, a1 * x + b1};
        }

        b1 = start1[1] - a1 * start1[0];
        b2 = start2[1] - a2 * start2[0];
        if (a1 == a2 && b1 != b2) {
            return empty();
        }
        if (a1 == a2 && b1 == b2) {
            x = getMinRange(new int[]{start1[0], end1[0]}, new int[]{start2[0], end2[0]});
            if (x < 0) {
                return empty();
            }
            return new double[]{x, a1 * x + b1};
        }

        x = (b2 - b1) / (a1 - a2);
        y = a1 * x + b1;

        if (!check(x, start1, end1) || !check(x, start2, end2)) {
            return empty();
        }

        return new double[]{x, y};

    }

    private static boolean check(double x, int[] start1, int[] end1) {
        int left, right;
        if (start1[0] <= end1[0]) {
            left = start1[0];
            right = end1[0];
        } else {
            right = start1[0];
            left = end1[0];
        }
        if (x < left || x > right) {
            return false;
        }
        return true;

    }
    private static double[] empty() {
        return new double[]{};
    }
    private static int getMinRange(int[] n1, int[] n2) {
        int[] left, right;
        if (n1[0] <= n2[0]) {
            left = n1;
            right = n2;
        } else {
            left = n2;
            right = n1;
        }
        if (right[0] > left[1]) {
            return -1;
        }
        return right[0];
    }
    
    public static void main(String[] args) {
        intersection(new int[]{1,1}, new int[]{-1,1}, new int[]{1,0}, new int[]{-3,2});
    }

}

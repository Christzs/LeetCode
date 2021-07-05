package com.leetcode.problem.medium;

/**
 /**
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 *
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 *
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 *
 * Example:
 *
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * Output: 45
 */
public class p223_RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);

        // 两矩形不相交
        if (ay1 > by2 || ay2 < by1) {
            return area;
        }
        if (ax1 > bx2 || ax2 < bx1) {
            return area;
        }

        // 两矩形相交
        int intersectArea = (Math.min(ax2, bx2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
        return area - intersectArea;
    }

    public static void main(String[] args) {
        p223_RectangleArea p223RectangleArea = new p223_RectangleArea();
        System.out.println(p223RectangleArea.computeArea(-3,0,3,4,0,-1, 9, 2));
    }

}

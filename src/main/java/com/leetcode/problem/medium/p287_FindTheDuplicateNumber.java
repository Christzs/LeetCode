package com.leetcode.problem.medium;

/**
 * 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)
 * , prove that at least one duplicate number must exist.
 *
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 */
public class p287_FindTheDuplicateNumber {

    /**
     * 快慢指针，寻找环的入口
     *
     * 假设相遇时, 快指针走了2s步，慢指针走了s步
     * 表头到环入口的距离为a，入口至相遇点距离为b，相遇点至入口距离为c，环的长度为L
     *
     * 那么有：L = b + c, s = a + b
     * 快指针在相遇前的距离又可表示为 a + b + kL，即在环中前进了k圈
     *
     * 则：2s = 2(a + b) = a + b + kL
     *    ===> a = kL - b = (k - 1)L + (L - b) = (k - 1)L + c
     * 此时，慢指针从表头出发，快指针从相遇点出发，两个指针每次前进一步
     *
     * 当慢指针走a步到达入口时，快指针应走a步， 且 a = (k - 1)L + c
     * 相遇点至入口距离为c，则证明 两指针再次相遇即为环的入口
     */
    public int findDuplicate(int[] nums) {

        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Integer transportId = 111;
        String platformKey = "dddaaaaa";
        System.out.println(String.format("进件[%d]未添加[%s]平台", transportId, platformKey));
    }

}

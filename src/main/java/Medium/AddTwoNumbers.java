package Medium;

/**
 * @Description
 *
 * 02 AddTwoNumbers
 *
 * You are given two non-empty linked lists representing two non-negative integers
 * The digits are stored in reverse order and each of their nodes contain a single digit
 * Add the two numbers and return it as a linked list
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: (7 -> 0 -> 8)
 *
 */

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null, thisNode = null, nextNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int valL1 = (l1 == null ? 0 : l1.val);
            int valL2 = (l2 == null ? 0 : l2.val);
            int sum = valL1 + valL2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = new ListNode(sum % 10);
                thisNode = head;
            } else {
                nextNode = new ListNode(sum % 10);
                thisNode.next = nextNode;
                thisNode = nextNode;
            }
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return head;
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long a = Long.parseLong(toString(l1));
        Long b = Long.parseLong(toString(l2));
        ListNode result = toNode(String.valueOf(a + b));
        return result;
    }

    public String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = node;
        sb.append(temp.val);
        while (temp.next != null) {
            sb.append(temp.next.val);
            temp = temp.next;
        }
        return sb.reverse().toString();
    }

    public ListNode toNode(String number) {
        ListNode next = null;
        ListNode temp = null;
        for (int i = 0; i < number.length(); i++) {
            String one = number.substring(i, i + 1);
            temp = new ListNode(Integer.parseInt(String.valueOf(one)));
            if (next != null) {
                temp.next = next;
                next = temp;
            } else {
                next = temp;
            }
        }
        return temp;
    }
}
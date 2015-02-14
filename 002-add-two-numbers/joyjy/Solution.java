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
        return addTwoNumbers(l1, l2, false);
    }
    
    public ListNode addTwoNumbers(ListNode n1, ListNode n2, boolean carry){
    	if(n1 == null && n2 == null && !carry){
    		return null;
    	}
    	
    	if(n1 == null){
    		n1 = new ListNode(0);
    	}
    	if(n2 == null){
    		n2 = new ListNode(0);
    	}
    	
    	int added = n1.val + n2.val + (carry?1:0);
    	
    	ListNode node = new ListNode(added%10);
    	node.next = addTwoNumbers(n1.next, n2.next, added > 9);
    	
    	return node;
    }
}
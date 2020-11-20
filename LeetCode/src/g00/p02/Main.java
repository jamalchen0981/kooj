/**
 * 
 */
package g00.p02;

/**
 * LeetCode 2. Add Two Numbers
 * Medium
 * 2ms, 39.3MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9, null);
		
		ListNode l2 = new ListNode(9, null);
		l2.next = new ListNode(9, null);
		l2.next.next = new ListNode(9, null);
		
		ListNode l3 = new Solution().addTwoNumbers(l1, l2);
		printf(l3);
	}
	
	private static void printf(ListNode l3) {
		boolean comma = false;
		ListNode head = l3;
		while(head != null) {
			if(comma) {
				System.out.print(",");
			}
			comma = true;
			System.out.print(head.val);
			head = head.next;
		}
	}

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode h1 = l1, h2 = l2, h3 = new ListNode(0, null), l3 = h3;
    	int carry = 0;
    	while(h1 != null || h2 != null) {
    		int v = 0;
    		if(h1 != null) {
    			v += h1.val;
    			h1 = h1.next;
    		}
    		if(h2 != null) {
    			v += h2.val;
    			h2 = h2.next;
    		}
    		v += carry;
    		carry = v / 10;
    		h3.val = v % 10;
    		if(h1 != null || h2 != null || carry > 0) {
    			h3.next = new ListNode(0, null);
    			h3 = h3.next;
    		}
    	}
    	if(carry > 0) {
    		h3.val = carry;
    	}
    	
    	return l3;
    }
}

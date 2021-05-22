/**
 * 
 */
package g00.p21;

/**
 * LeetCode 21. Merge Two Sorted Lists
 * Easy
 * 0 ms, 38.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1_4 = new ListNode(4, null);
		ListNode l1_2 = new ListNode(2, l1_4);
		ListNode l1_1 = new ListNode(1, l1_2);
		
		ListNode l2_4 = new ListNode(4, null);
		ListNode l2_3 = new ListNode(3, l2_4);
		ListNode l2_1 = new ListNode(1, l2_3);
		
		ListNode head = new Solution().mergeTwoLists(l1_1, l2_1);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
class Solution {	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
        	return l2;
        } else if(l2 == null) {
        	return l1;
        }
        
        ListNode h1 = null, h2 = null, p1 = null, prev = null, head = null;
        if(l1.val < l2.val) {
        	h1 = l1;
        	h2 = l2;
        } else {
        	h1 = l2;
        	h2 = l1;
        }
    	p1 = new ListNode(h1.val, null);
    	prev = p1;
    	head = p1;
    	p1 = p1.next;
        h1 = h1.next;
        
        while(h1 != null || h2 != null) {
        	if(h1 == null) {
        		p1 = new ListNode(h2.val, null);
        		prev.next = p1;
        		prev = p1;
        		p1 = p1.next;
        		h2 = h2.next;
        	} else if(h2 == null) {
        		p1 = new ListNode(h1.val, null);
        		prev.next = p1;
        		prev = p1;
        		p1 = p1.next;
        		h1 = h1.next;
        	} else {
	        	if(h1.val < h2.val) {
	        		p1 = new ListNode(h1.val, null);
	        		prev.next = p1;
	        		prev = p1;
	        		p1 = p1.next;
	        		h1 = h1.next;
	        	} else {
	        		p1 = new ListNode(h2.val, null);
	        		prev.next = p1;
	        		prev = p1;
	        		p1 = p1.next;
	        		h2 = h2.next;
	        	}
        	}
        }
        
        return head;
    }
}


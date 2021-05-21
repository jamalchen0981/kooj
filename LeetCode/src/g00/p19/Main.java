/**
 * 
 */
package g00.p19;

/**
 * 19. Remove Nth Node From End of List
 * Medium
 * 0 ms, 36.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode ln5 = new ListNode(5, null);
		ListNode ln4 = new ListNode(4, ln5);
		ListNode ln3 = new ListNode(3, ln4);
		ListNode ln2 = new ListNode(2, ln3);
		ListNode ln1 = new ListNode(1, ln2);
		ListNode head = new Solution().removeNthFromEnd(ln1, 1);
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
	
	private int count;
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
		remove(head, n);
		count += 1;
		if(count == n + 1) {
			head = head.next;
		}
		
		return head;
    }
	
	private void remove(ListNode ln, int n) {
		if(ln == null) {
			count = 0;
		} else {
			remove(ln.next, n);
			count += 1;
			if(count == n + 1) {
				ln.next = ln.next.next;
			}
		}
	}
}


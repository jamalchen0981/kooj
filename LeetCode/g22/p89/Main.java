/**
 * 
 */
package g22.p89;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 2289. Steps to Make Array Non-decreasing
 * Medium
 * 43 ms, 86.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().totalSteps(new int[] {5,3,4,4,7,3,6,11,8,5,11}));
		System.out.println(new Solution().totalSteps(new int[] {10,1,2,3,4,5,6,1,2,3}));
	}
}

class Solution {
    public int totalSteps(int[] nums) {
    	int n = nums.length;
        int[] steps = new int[n];
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            int maxSteps = 0;
            while(!deque.isEmpty() && (nums[deque.peekLast()] <= nums[i])) {
                int index = deque.removeLast();
                maxSteps = Math.max(maxSteps, steps[index]);
            }
            
            if(deque.isEmpty()) maxSteps = 0;
            else maxSteps += 1;
            steps[i] = maxSteps;
            deque.offerLast(i);
            ans = Math.max(ans, maxSteps);
        }
        return ans;
    }
}

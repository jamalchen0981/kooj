/**
 * 
 */
package g07.p40;

import java.util.Arrays;

/**
 * LeetCode 740. Delete and Earn
 * Medium
 * 3 ms, 42.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(new Solution().deleteAndEarn(new int[] {3,4,2}));
		//System.out.println(new Solution().deleteAndEarn(new int[] {2,2,3,3,3,4}));
		//System.out.println(new Solution().deleteAndEarn(new int[] {4,10,10,8,1,4,10,9,7,6}));
		System.out.println(new Solution().deleteAndEarn(new int[] {8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4}));
	}
}

class Solution {
    public int deleteAndEarn(int[] nums) {
    	int[] cost = new int[10002];
    	Arrays.fill(cost, 0);
    	for(int i = 0 ; i < nums.length; ++i) {
    		cost[nums[i]] += 1;
    	}
    	int prev = 0;
    	int inc = 0;
    	for(int i = 1; i <= 10000; ++i) {
    		int v1 = prev + i * cost[i];
    		int v2 = Math.max(inc, prev);
    		inc = v1;
    		prev = v2;
    	}
    	return Math.max(inc, prev);
    }
}
/**
 * 
 */
package g00.p45;

import java.util.Arrays;

/**
 * LeetCode 45. Jump Game II
 * Medium
 * 45 ms, 50 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().jump(new int[] {2,3,1,1,4}));
		System.out.println(new Solution().jump(new int[] {2,3,0,1,4}));
	}
}

class Solution {
    public int jump(int[] nums) {
    	if(nums.length == 1) {
    		return 0;
    	}
    	int[] dp = new int[nums.length + 1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for(int i = 0; i < nums.length; ++i) {
    		int j = Math.min(i + nums[i], nums.length - 1);
    		
    		for(; j < nums.length && j > i; --j) {
    			dp[j] = Math.min(dp[j], dp[i] + 1);
    		}
    	}
        return dp[nums.length - 1];
    }
}


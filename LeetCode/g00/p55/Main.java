/**
 * 
 */
package g00.p55;

import java.util.Arrays;

/**
 * LeetCode 55. Jump Game
 * Medium
 * 51 ms, 43.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().canJump(new int[] {2,3,1,1,4}));
		System.out.println(new Solution().canJump(new int[] {2,0}));
	}
}

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
        	return true;
        }
        
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 1; i < nums.length; ++i) {
        	for(int j = i - 1; j >= 0; --j) {
        		if(dp[j] && j + nums[j] >= i) {
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[nums.length - 1];
    }
}


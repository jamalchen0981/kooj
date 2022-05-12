/**
 * 
 */
package g01.p98;

import java.util.Arrays;

/**
 * LeetCode 198. House Robber
 * Medium
 * 0 ms, 41.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().rob(new int[] {1,2,3,1}));
		System.out.println(new Solution().rob(new int[] {2,7,9,3,1}));
	}
}

class Solution {
    public int rob(int[] nums) {
    	if(nums.length <= 1) {
    		return nums[0];
    	}
    	if(nums.length <= 2) {
    		return Math.max(nums[0], nums[1]);
    	}
        int[] money = new int[nums.length];
        Arrays.fill(money, 0);
        money[0] = nums[0];
        money[1] = nums[1];
        int prevMax = 0;
        for(int i = 2; i < nums.length; ++i) {
        	money[i] = Math.max(money[i - 1], nums[i] + Math.max(prevMax, money[i - 2]));
        	prevMax = Math.max(money[i - 1], money[i - 2]);
        }
        return money[nums.length - 1];
    }
}

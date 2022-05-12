/**
 * 
 */
package g02.p13;

/**
 * LeetCode 213. House Robber II
 * Medium
 * 0 ms, 42.3 MB
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
		System.out.println(new Solution().rob(new int[] {1,2,3}));
	}
}

class Solution {
    public int rob(int[] nums) {
    	if(nums.length <= 1) {
    		return nums[0];
    	}
    	return Math.max(cal(nums, 0, nums.length - 1), cal(nums, 1, nums.length));
    }
    
    private int cal(int[] nums, int begin, int end) {
    	int prev2 = 0, prev = 0, max = 0;
    	for(int i = begin; i < end; ++i) {
    		max = Math.max(prev2 + nums[i], prev);
    		prev2 = prev;
    		prev = max;
    	}
    	return max;
    }
}

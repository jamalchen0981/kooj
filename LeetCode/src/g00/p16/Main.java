/**
 * 
 */
package g00.p16;

import java.util.Arrays;

/**
 * LeetCode 16. 3Sum Closest
 * Medium
 * 8 ms, 39 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().threeSumClosest(new int[] {-1,2,1,-4}, 1));
		System.out.println(new Solution().threeSumClosest(new int[] {1,1,-1}, 0));
	}

}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int ans = 10000, ans_t = 10000;
    	for(int i = 0; i < nums.length; ++i) {
    		int pre_j = 10000;
    		int last_k = nums.length - 1;
    		for(int j = i + 1; j < nums.length; ++j) {
    			if(nums[j] != pre_j) {
    				pre_j = nums[j];
	    			int s = nums[i] + nums[j];
	    			int prev = 10000;
	    			int pre_k = 10000;
	    			for(int k = last_k; k > j; --k) {
	    				if(nums[k] != pre_k) {
	    					pre_k = nums[k];
		    				int s2 = s + nums[k];
		    				int t = Math.abs(s2 - target);
		    				if(t <= prev) {
		    					last_k = k;
		    					if(t <= ans_t) {
		    						ans = s2;
		    						ans_t = t;
		    					}
		    					prev = t;
		    				} else {
		    					break;
		    				}
	    				}
	    			}
    			}
    		}
    	}
    	
        return ans;
    }
}


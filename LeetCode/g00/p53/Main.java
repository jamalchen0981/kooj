/**
 * 
 */
package g00.p53;

/**
 * LeetCode 53. Maximum Subarray
 * Easy
 * 3 ms, 51.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(new Solution().maxSubArray(new int[] {1}));
		System.out.println(new Solution().maxSubArray(new int[] {5,4,-1,7,8}));
		System.out.println(new Solution().maxSubArray(new int[] {-1, -2}));
	}
}

class Solution {
    public int maxSubArray(int[] nums) {
        int x = -1;
        int v = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i) {
        	if(nums[i] >= 0) {
        		x = i;
        		v = nums[i];
        		if(v > max) {
        			max = v;
        		}
        		break;
        	}
        }
        for(int i = x + 1; i < nums.length; ++i) {
        	if(nums[i] >= 0) {
        		if(nums[i] >= v && v < 0) {
        			v = 0;
        		}
        	}
        	v += nums[i];
        	if(v > max) {
        		max = v;
        	}
        }
        if(x == -1) {
        	for(int i = 0; i < nums.length; ++i) {
        		if(nums[i] > max) {
        			max = nums[i];
        		}
        	}
        }
        return max;
    }
}


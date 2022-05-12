/**
 * 
 */
package g16.p08;

import java.util.Arrays;

/**
 * LeetCode 1608. Special Array With X Elements Greater Than or Equal X
 * Easy
 * 2 ms, 42.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().specialArray(new int[] {3,5}));
		System.out.println(new Solution().specialArray(new int[] {0,0}));
		System.out.println(new Solution().specialArray(new int[] {0,4,3,0,4}));
	}
}

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i <= nums.length; ++i) {
        	int j = nums.length - i;
        	if(j - 1 >= 0) {
        		if(nums[j - 1] < i && nums[j] >= i) {
        			return i;
        		}
        	} else {
        		if(nums[j] >= i) {
        			return i;
        		}
        	}
        }
        return -1;
    }
}

/**
 * 
 */
package g22.p94;

import java.util.Arrays;

/**
 * LeetCode 2294. Partition Array Such That Maximum Difference Is K
 * Medium
 * 40 ms, 77 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().partitionArray(new int[] {3,6,1,2,5}, 2));
		System.out.println(new Solution().partitionArray(new int[] {1,2,3}, 1));
		System.out.println(new Solution().partitionArray(new int[] {2,2,4, 5}, 0));
	}
}

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int d = 1;
        int n = nums[0];
        for(int i = 1; i < nums.length; ++i) {
        	if(!(nums[i] - n <= k)) {
        		n = nums[i];
        		d += 1;
        	}
        }
        return d;
    }
}

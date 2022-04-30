/**
 * 
 */
package g22.p39;

/**
 * LeetCode 2239. Find Closest Number to Zero
 * Easy
 * 3 ms, 52 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().findClosestNumber(new int[] {-4,-2,1,4,8}));
		System.out.println(new Solution().findClosestNumber(new int[] {2,-1,1}));
	}
}

class Solution {
    public int findClosestNumber(int[] nums) {
        int v = Integer.MIN_VALUE, m = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; ++i) {
        	int a = Math.abs(nums[i]);
        	if(a < m) {
        		m = a;
        		v = nums[i];
        	} else if(a == m) {
        		if(v < nums[i]) {
        			v = nums[i];
        		}
        	}
        }
        return v;
    }
}


/**
 * 
 */
package g22.p56;

/**
 * LeetCode 2256. Minimum Average Difference
 * Medium
 * 21 ms, 74.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minimumAverageDifference(new int[] {2,5,3,9,5,3}));
		System.out.println(new Solution().minimumAverageDifference(new int[] {0}));
	}
}

class Solution {
    public int minimumAverageDifference(int[] nums) {
        if(nums.length <= 1) {
        	return 0;
        }
        long sum = 0L;
        for(int i = 0; i < nums.length; ++i) {
        	sum += nums[i];
        }
        int x = -1;
        long v = Long.MAX_VALUE;
        long a1 = 0L;
        for(int i = 0; i < nums.length; ++i) {
        	a1 += nums[i];
        	long a2 = sum - a1;
        	int b1 = i + 1;
        	int b2 = nums.length - (i + 1);
        	long d = 0;
        	if(b2 > 0) {
        		d = Math.abs(a1 / b1 - a2 / b2);
        	} else {
        		d = Math.abs(a1 / b1);
        	}
        	if(d < v) {
        		v = d;
        		x = i;
        	}
        }
        return x;
    }
}


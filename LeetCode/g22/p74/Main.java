/**
 * 
 */
package g22.p74;

import java.util.Arrays;

/**
 * LeetCode 2274. Maximum Consecutive Floors Without Special Floors
 * Medium
 * 45 ms, 78.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maxConsecutive(2, 9, new int[] {4, 6}));
		System.out.println(new Solution().maxConsecutive(6, 8, new int[] {7, 6, 8}));
	}
}

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
    	Arrays.sort(special);
    	int max = 0;
        if(special.length == 1) {
        	if(max < special[0] - bottom) {
        		max = special[0] - bottom;
        	}
        	if(max < top - special[0]) {
        		max = top - special[0];
        	}
        } else {
        	if(max < special[0] - bottom) {
        		max = special[0] - bottom;
        	}
        	for(int i = 1; i < special.length; ++i) {
        		if(max < special[i] - special[i - 1] - 1) {
        			max = special[i] - special[i - 1] - 1;
        		}
        	}
        	if(max < top - special[special.length - 1]) {
        		max = top - special[special.length - 1];
        	}
        }
        return max;
    }
}

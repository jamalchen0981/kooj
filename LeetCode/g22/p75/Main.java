/**
 * 
 */
package g22.p75;

import java.util.Arrays;

/**
 * LeetCode 2275. Largest Combination With Bitwise AND Greater Than Zero
 * Medium
 * 51 ms, 83.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().largestCombination(new int[] {16,17,71,62,12,24,14}));
		System.out.println(new Solution().largestCombination(new int[] {8,8}));
	}
}

class Solution {
    public int largestCombination(int[] candidates) {
        if(candidates.length == 1) {
        	return 1;
        }
        int[] ary = new int[31];
        Arrays.fill(ary, 0);
        for(int i = 0; i < candidates.length; ++i) {
        	for(int j = 0; j < 31; ++j) {
        		if(((candidates[i] >> j) & 1) != 0) {
        			ary[j] += 1;
        		}
        	}
        }
        int max = 0;
        for(int i = 0; i < 31; ++i) {
        	if(max < ary[i]) {
        		max = ary[i];
        	}
        }
        return max;
    }
}

/**
 * 
 */
package g00.p70;

import java.util.Arrays;

/**
 * LeetCode 70. Climbing Stairs
 * Easy
 * 0 ms, 38.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(2));
		System.out.println(new Solution().climbStairs(3));
	}
}

class Solution {
    public int climbStairs(int n) {
        int[] ary = new int[n + 1];
        Arrays.fill(ary, 0);
        ary[0] = 1;
        for(int i = 1; i <= n; ++i) {
        	if(i - 1 >= 0) {
        		ary[i] += ary[i - 1];
        	}
        	if(i - 2 >= 0) {
        		ary[i] += ary[i - 2];
        	}
        }
        return ary[n];
    }
}


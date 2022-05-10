/**
 * 
 */
package g07.p46;

import java.util.Arrays;

/**
 * LeetCode 746. Min Cost Climbing Stairs
 * Easy
 * 2 ms, 43.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minCostClimbingStairs(new int[] {10,15,20}));
		System.out.println(new Solution().minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
		System.out.println(new Solution().minCostClimbingStairs(new int[] {1, 100}));
	}
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
    	int min = Integer.MAX_VALUE;
    	int[] ary = new int[cost.length + 1];
        Arrays.fill(ary, 0);
        ary[0] = cost[0];
        for(int i = 1; i < cost.length; ++i) {
        	if(i - 1 >= 0 && i - 2 >= 0) {
        		ary[i] = Math.min(ary[i - 1], ary[i - 2]) + cost[i];
        	} else {
        		ary[i] = ary[i - 1] + cost[i];
        	}
        }
        if(cost.length - 1 >= 0 && cost.length - 2 >= 0) {
        	ary[cost.length] = Math.min(ary[cost.length - 1], ary[cost.length - 2]);
        } else {
        	ary[cost.length] = ary[cost.length - 1];
        }
        if(min > ary[cost.length]) {
        	min = ary[cost.length];
        }
        int[] ary2 = new int[cost.length + 1];
        Arrays.fill(ary2, 0);
        ary2[1] = cost[1];
        for(int i = 2; i < cost.length; ++i) {
        	if(i - 1 >= 1 && i - 2 >= 1) {
        		ary2[i] = Math.min(ary2[i - 1], ary2[i - 2]) + cost[i];
        	} else {
        		ary2[i] = ary2[i - 1] + cost[i];
        	}
        }
        if(cost.length - 1 >= 1 && cost.length - 2 >= 1) {
        	ary2[cost.length] = Math.min(ary2[cost.length - 1], ary2[cost.length - 2]);
        } else {
        	ary2[cost.length] = ary2[cost.length - 1];
        }
        if(min > ary2[cost.length]) {
        	min = ary2[cost.length];
        }
        return min;
    }
}
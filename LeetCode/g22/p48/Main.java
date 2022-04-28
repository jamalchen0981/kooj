/**
 * 
 */
package g22.p48;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 2248. Intersection of Multiple Arrays
 * Easy
 * 3 ms, 46.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().intersection(new int[][] {{3,1,2,4,5}, {1,2,3,4}, {3,4,5,6}}));
	}
}

class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        
        int[] x = new int[1001];
        for(int i = 0; i < 1001; ++i) {
        	x[i] = 0;
        }
        
        for(int i = 0; i < nums.length; ++i) {
        	for(int j = 0; j < nums[i].length; ++j) {
        		x[nums[i][j]] += 1;
        	}
        }
        
        for(int i = 0; i < 1001; ++i) {
        	if(x[i] == nums.length) {
        		list.add(i);
        	}
        }
        
        return list;
    }
}


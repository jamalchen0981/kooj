/**
 * 
 */
package g13.p51;

/**
 * LeetCode 1351. Count Negative Numbers in a Sorted Matrix
 * Easy
 * 1 ms, 49.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().countNegatives(new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
	}
}

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; ++i) {
        	for(int j = grid[i].length - 1; j >= 0; --j) {
        		if(grid[i][j] < 0) {
        			count += 1;
        		} else {
        			break;
        		}
        	}
        }
        return count;
    }
}

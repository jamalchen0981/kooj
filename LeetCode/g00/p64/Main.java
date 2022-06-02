/**
 * 
 */
package g00.p64;

/**
 * LeetCode 64. Minimum Path Sum
 * Medium
 * 7 ms, 46.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minPathSum(
				new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
		System.out.println(new Solution().minPathSum(
				new int[][] {{1,2,3},{4,5,6}}));
	}
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ary = new int[m][n];
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		ary[i][j] = grid[i][j];
        		if(i - 1 >= 0 && j - 1 >= 0) {
        			ary[i][j] += Math.min(ary[i - 1][j], ary[i][j - 1]);
        		} else if(i - 1 >= 0) {
        			ary[i][j] += ary[i - 1][j];
        		} else if(j - 1 >= 0) {
        			ary[i][j] += ary[i][j - 1];
        		}
        	}
        }
        return ary[m - 1][n - 1];
    }
}

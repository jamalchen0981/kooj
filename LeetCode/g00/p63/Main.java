/**
 * 
 */
package g00.p63;

/**
 * LeetCode 63. Unique Paths II
 * Medium
 * 0 ms, 40.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().uniquePathsWithObstacles(
				new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
		System.out.println(new Solution().uniquePathsWithObstacles(
				new int[][] {{0,1},{0,0}}));
	}
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	if(m == 1 && n == 1 && obstacleGrid[0][0] == 1) {
    		return 0;
    	}
        int[][] ary = new int[m][n];
        ary[0][0] = 1;
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(obstacleGrid[i][j] == 0) {
        			if(i - 1 >= 0 && obstacleGrid[i - 1][j] == 0) {
        				ary[i][j] += ary[i - 1][j];
        			}
        			if(j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
        				ary[i][j] += ary[i][j - 1];
        			}
        		}
        	}
        }
        return ary[m - 1][n - 1];
    }
}

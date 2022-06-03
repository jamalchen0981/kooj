/**
 * 
 */
package g00.p85;

/**
 * LeetCode 85. Maximal Rectangle
 * Hard
 * 18 ms, 54.9 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'1','0','1','0','0'},
					{'1','0','1','1','1'},
					{'1','1','1','1','1'},
					{'1','0','0','1','0'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'0'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'1'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'1','0','0','1','0'},
					{'1','0','1','1','1'},
					{'1','1','1','1','1'},
					{'1','0','1','1','1'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'1','0'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'0','1'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'1','1'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'0','1'},
					{'0','1'}}));
		System.out.println(new Solution().maximalRectangle(
				new char[][] {{'0','0','1'},
					{'1','1','1'}}));
		

	}
}

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; ++i) {
        	dp[m - 1][i] = matrix[m - 1][i] - '0';
        	for(int j = m - 2; j >= 0; --j) {
        		if(matrix[j][i] == '1') {
        			dp[j][i] += dp[j + 1][i] + 1;
        		}
        	}
        }
        int max = 0;
        for(int i = 0; i < m; ++i) {
        	for(int k = 0; k < n; ++k) {
        		if(dp[i][k] == 0) {
        			continue;
        		}
        		int mini = Integer.MAX_VALUE;
        		for(int j = k; j < n; ++j) {
        			if(dp[i][j] == 0) {
        				break;
        			}
        			mini = Math.min(mini, dp[i][j]);
        			max = Math.max(max, mini * (j - k + 1));
        		}
        	}
        }
        return max;
    }
}


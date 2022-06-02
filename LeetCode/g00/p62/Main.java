/**
 * 
 */
package g00.p62;

/**
 * LeetCode 62. Unique Paths
 * Medium
 * 0 ms, 41.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(3, 7));
		System.out.println(new Solution().uniquePaths(3, 2));
	}
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ary = new int[m][n];
        ary[0][0] = 1;
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(i - 1 >= 0) {
        			ary[i][j] += ary[i - 1][j];
        		}
        		if(j - 1 >= 0) {
        			ary[i][j] += ary[i][j - 1];
        		}
        	}
        }
        return ary[m - 1][n - 1];
    }
}


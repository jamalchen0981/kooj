/**
 * 
 */
package g22.p57;

/**
 * LeetCode 2257. Count Unguarded Cells in the Grid
 * Medium
 * 27ms, 128.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().countUnguarded(4, 6, new int[][] {{0, 0}, {1, 1}, {2, 3}}, 
				new int[][] {{0, 1}, {2, 2}, {1, 4}}));
	}
}

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] a = new char[m][n];
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		a[i][j] = '0';
        	}
        }
        for(int i = 0; i < guards.length; ++i) {
        	a[guards[i][0]][guards[i][1]] = '1';
        }
        for(int i = 0; i < walls.length; ++i) {
        	a[walls[i][0]][walls[i][1]] = '2';
        }
        for(int i = 0; i < guards.length; ++i) {
        	// top
        	for(int p = guards[i][0] - 1, q = guards[i][1]; p >= 0; --p) {
        		if(a[p][q] == '2' || a[p][q] == '1') {
        			break;
        		}
        		a[p][q] = '3';
        	}
        	// down
        	for(int p = guards[i][0] + 1, q = guards[i][1]; p < m; ++p) {
        		if(a[p][q] == '2' || a[p][q] == '1') {
        			break;
        		}
        		a[p][q] = '3';
        	}
        	// left
        	for(int p = guards[i][0], q = guards[i][1] - 1; q >= 0; --q) {
        		if(a[p][q] == '2' || a[p][q] == '1') {
        			break;
        		}
        		a[p][q] = '3';
        	}
        	// right
        	for(int p = guards[i][0], q = guards[i][1] + 1; q < n; ++q) {
        		if(a[p][q] == '2' || a[p][q] == '1') {
        			break;
        		}
        		a[p][q] = '3';
        	}
        }
        int count = 0;
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(a[i][j] == '0') {
        			count += 1;
        		}
        	}
        }
        return count;
    }
}


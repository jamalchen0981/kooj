/**
 * 
 */
package g00.p74;

/**
 * LeetCode 70. Climbing Stairs
 * Medium
 * 0 ms, 43.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
		System.out.println(new Solution().searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
	}
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; ++i) {
        	if(matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
        		int lo = 0, hi = matrix[i].length - 1;
        		while(lo <= hi) {
        			int mid = lo + (hi - lo) / 2;
        			if(matrix[i][mid] == target) {
        				return true;
        			}
        			
        			if(matrix[i][mid] < target) {
        				lo = mid + 1;
        			} else {
        				hi = mid - 1;
        			}
        		}
        		break;
        	}
        }
        return false;
    }
}


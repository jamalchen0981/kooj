/**
 * 
 */
package g00.p36;

/**
 * LeetCode 36. Valid Sudoku
 * Medium
 * 2 ms, 42.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().isValidSudoku(new char[][] {{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}}));
		System.out.println(new Solution().isValidSudoku(new char[][] {{'8','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}}));
	}
}

class Solution {
	public boolean isValidSudoku(char[][] board) {
		// row
        for(int i = 0; i < 9; ++i) {
        	int[] count = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        	for(int j = 0; j < 9; ++j) {
        		if(board[i][j] != '.') {
        			count[board[i][j] - '1'] += 1;
        		}
        	}
        	for(int j = 0; j < 9; ++j) {
        		if(count[j] > 1) {
        			return false;
        		}
        	}
        }
		
        // column
        for(int i = 0; i < 9; ++i) {
        	int[] count = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        	for(int j = 0; j < 9; ++j) {
        		if(board[j][i] != '.') {
        			count[board[j][i] - '1'] += 1;
        		}
        	}
        	for(int j = 0; j < 9; ++j) {
        		if(count[j] > 1) {
        			return false;
        		}
        	}
        }
        
        // 3 x 3
        for(int i = 0; i < 9; i += 3) {
        	for(int j = 0; j < 9; j += 3) {
        		int[] count = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        		for(int m = i; m < i + 3; ++m) {
        			for(int n = j; n < j + 3; ++n) {
        				if(board[m][n] != '.') {
                			count[board[m][n] - '1'] += 1;
                		}
        			}
        		}
        		for(int m = 0; m < 9; ++m) {
            		if(count[m] > 1) {
            			return false;
            		}
            	}
        	}
        }
        
        return true;
    }
}


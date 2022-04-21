/**
 * 
 */
package g00.p37;

/**
 * LeetCode 37. Sudoku Solver
 * Hard
 * 17 ms, 42.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = new char[][] {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}};
		new Solution().solveSudoku(board);
		System.out.print("{");
		for(int i = 0; i < 9; ++i) {
			if(i > 0) {
				System.out.print(", ");
			}
			System.out.print("{");
			for(int j = 0; j < 9; ++j) {
				if(j > 0) {
					System.out.print(", ");
				}
				System.out.print(board[i][j]);
			}
			System.out.print("}");
		}
		System.out.print("}");
	}
}

class Solution {
	boolean flag;
	
    public void solveSudoku(char[][] board) {
		flag = false;
		recursive(board, 0, 0);
    }
    
    private void recursive(char[][] board, int i, int j) {
    	if(j == 9) {
    		if(i + 1 == 9) {
    			flag = true;
    			return;
    		}
    		recursive(board, i + 1, 0);
    	} else if(board[i][j] != '.') {
    		recursive(board, i, j + 1);
    	} else if(board[i][j] == '.') {
			char[] c = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
			for(int k = 0; k < 9; ++k) {
				board[i][j] = c[k];
				if(isValidSudoku_xy(board, i, j)) {
					recursive(board, i, j + 1);
					if(flag) {
						return;
					}
				}
				board[i][j] = '.';
			}
    	}
    }
    
    private boolean isValidSudoku_xy(char[][] board, int x, int y) {
		// row
    	{
        	int[] count = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        	for(int j = 0; j < 9; ++j) {
        		if(board[x][j] != '.') {
        			count[board[x][j] - '1'] += 1;
        		}
        	}
        	for(int j = 0; j < 9; ++j) {
        		if(count[j] > 1) {
        			return false;
        		}
        	}
        }
		
        // column
    	{
    		int[] count = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
	        for(int i = 0; i < 9; ++i) {       	
	        	if(board[i][y] != '.') {
        			count[board[i][y] - '1'] += 1;
        		}
	        }
        	for(int j = 0; j < 9; ++j) {
        		if(count[j] > 1) {
        			return false;
        		}
        	}
        }
        
        // 3 x 3
    	boolean found = false;
        for(int i = 0; i < 9; i += 3) {
        	if(i <= x && x < i + 3) {
	        	for(int j = 0; j < 9; j += 3) {
	        		if(j <= y && y < j + 3) {
	        			found = true;
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
	        		if(found) {
		        		break;
		        	}
	        	}
	        	if(found) {
	        		break;
	        	}
        	}
        }
        
        return true;
    }
}


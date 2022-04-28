/**
 * 
 */
package g22.p45;

/**
 * LeetCode 2245. Maximum Trailing Zeros in a Cornered Path
 * Medium
 * 190 ms, 69.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maxTrailingZeros(new int[][] {{23,17,15,3,20}, {8,1,20,27,11}, {9,4,6,2,21}, 
			{40,9,1,10,6}, {22,7,4,5,3}}));
		System.out.println(new Solution().maxTrailingZeros(new int[][] {{335,165,39,984},{754,40,231,885},
			{606,672,450,122},{643,931,401,489}}));
		System.out.println(new Solution().maxTrailingZeros(new int[][] {{242,921,651,509,130,857},
			{486,959,4,159,150,655},{825,644,838,771,101,199},{781,770,193,492,930,670},
			{395,474,960,839,616,652},{895,156,833,124,863,907},{603,921,383,279,654,933}}));
		System.out.println(new Solution().maxTrailingZeros(new int[][] {{824,709,193,413,701,836,727},
			{135,844,599,211,140,933,205},{329,68,285,282,301,387,231},{293,210,478,352,946,902,137},
			{806,900,290,636,589,522,611},{450,568,990,592,992,128,92},{780,653,795,457,980,942,927},
			{849,901,604,906,912,866,688}}));
		System.out.println(new Solution().maxTrailingZeros(new int[][] {{284,853,142,786,199,286},
			{910,227,820,584,593,384},{519,801,66,833,587,404},{360,819,518,360,16,975},
			{145,265,177,826,219,859},{410,111,353,259,902,406}}));
		System.out.println(new Solution().maxTrailingZeros(new int[][] {{899,727,165,249,531,300,542,890},
			{981,587,565,943,875,498,582,672},{106,902,524,725,699,778,365,220}}));
		System.out.println(new Solution().maxTrailingZeros(new int[][] {{437,230,648,905,744,416},
			{39,193,421,344,755,154},{480,200,820,226,681,663},{658,65,689,621,398,608},
			{680,741,889,297,530,547},{809,760,975,874,524,717}}));
	}
}

class Solution {
	
    public int maxTrailingZeros(int[][] grid) {
        int maxZeros = 0;
        int[][] twos = new int[grid.length][grid[0].length];
        int[][] fives = new int[grid.length][grid[0].length];
        int[][][][] zeros = new int[grid.length][grid[0].length][2][2];
        // dimension3: 0 is horizontal, 1 is vertical
        // dimension4: 0 is twos, 1 is fives
        for(int i = 0; i < grid.length; ++i) {
        	for(int j = 0; j < grid[0].length; ++j) {
        		twos[i][j] = fives[i][j] = 0;
        		int value = grid[i][j];
        		boolean isDivided = true;
        		while(value > 0 && isDivided) {
        			isDivided = false;
        			if(value % 2 == 0) {
        				value /= 2;
        				twos[i][j] += 1;
        				isDivided = true;
        			} else if(value % 5 == 0) {
        				value /= 5;
        				fives[i][j] += 1;
        				isDivided = true;
        			}
        		}
        		for(int m = 0; m < 2; ++m) {
        			for(int n = 0; n < 2; ++n) {
        				zeros[i][j][m][n] = 0;
        			}
        		}
        	}
        }
        for(int i = 0; i < grid.length; ++i) {
        	for(int j = 0; j < grid[0].length; ++j) {
        		zeros[i][j][0][0] = twos[i][j];
        		if(j > 0) {
        			zeros[i][j][0][0] += zeros[i][j - 1][0][0];
        		}
        		zeros[i][j][0][1] = fives[i][j];
        		if(j > 0) {
        			zeros[i][j][0][1] += zeros[i][j - 1][0][1];
        		}
        	}
        }
        for(int i = 0; i < grid[0].length; ++i) {
        	for(int j = 0; j < grid.length; ++j) {
        		zeros[j][i][1][0] = twos[j][i];
        		if(j > 0) {
        			zeros[j][i][1][0] += zeros[j - 1][i][1][0];
        		}
        		zeros[j][i][1][1] = fives[j][i];
        		if(j > 0) {
        			zeros[j][i][1][1] += zeros[j - 1][i][1][1];
        		}
        	}
        }
        for(int i = 0; i < grid.length; ++i) {
        	for(int j = 0; j < grid[0].length; ++j) {
        		int left_top_2 = zeros[i][j][0][0] + zeros[i][j][1][0] - twos[i][j];
        		int left_top_5 = zeros[i][j][0][1] + zeros[i][j][1][1] - fives[i][j];
        		int left_top = Math.min(left_top_2, left_top_5);
        		int left_bottom_2 = zeros[i][j][0][0] + (zeros[grid.length - 1][j][1][0] - zeros[i][j][1][0]);
        		int left_bottom_5 = zeros[i][j][0][1] + (zeros[grid.length - 1][j][1][1] - zeros[i][j][1][1]);
        		int left_bottom = Math.min(left_bottom_2, left_bottom_5);
        		int right_top_2 = (zeros[i][grid[0].length - 1][0][0] - zeros[i][j][0][0]) + zeros[i][j][1][0];
        		int right_top_5 = (zeros[i][grid[0].length - 1][0][1] - zeros[i][j][0][1]) + zeros[i][j][1][1];
        		int right_top = Math.min(right_top_2, right_top_5);
        		int right_bottom_2 = 0;
        		int right_bottom_5 = 0;
        		if(i != grid.length - 1 && j != grid[0].length - 1) {
        			right_bottom_2 = (zeros[i][grid[0].length - 1][0][0] - zeros[i][j][0][0]) + (zeros[grid.length - 1][j][1][0] - zeros[i][j][1][0]) + twos[i][j];
        			right_bottom_5 = (zeros[i][grid[0].length - 1][0][1] - zeros[i][j][0][1]) + (zeros[grid.length - 1][j][1][1] - zeros[i][j][1][1]) + fives[i][j];
        		} else if(i == grid.length - 1 && j == grid[0].length - 1) {
        			right_bottom_2 = twos[i][j];
        			right_bottom_5 = fives[i][j];
        		} else {
        			right_bottom_2 = (zeros[i][grid[0].length - 1][0][0] - zeros[i][j][0][0]) + (zeros[grid.length - 1][j][1][0] - zeros[i][j][1][0]);
        			right_bottom_5 = (zeros[i][grid[0].length - 1][0][1] - zeros[i][j][0][1]) + (zeros[grid.length - 1][j][1][1] - zeros[i][j][1][1]);
        		}
        		int right_bottom = Math.min(right_bottom_2, right_bottom_5);
        		int trailingZeros = Math.max(Math.max(Math.max(left_top, left_bottom), right_top), right_bottom);
        		if(maxZeros < trailingZeros) {
        			maxZeros = trailingZeros;
        		}
        	}
        }
        
        return maxZeros;
    }
}


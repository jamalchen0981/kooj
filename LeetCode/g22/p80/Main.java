/**
 * 
 */
package g22.p80;

import java.util.Arrays;

/**
 * LeetCode 2280. Minimum Lines to Represent a Line Chart
 * Medium
 * 81 ms, 109.8 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minimumLines(new int[][] {{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}}));
		System.out.println(new Solution().minimumLines(new int[][] {{3,4},{1,2},{7,8},{2,3}}));
		System.out.println(new Solution().minimumLines(new int[][] {{72,98},{62,27},{32,7},{71,4},{25,19},{91,30},
			{52,73},{10,9},{99,71},{47,22},{19,30},{80,63},{18,15},{48,17},{77,16},{46,27},{66,87},{55,84},{65,38},
			{30,9},{50,42},{100,60},{75,73},{98,53},{22,80},{41,61},{37,47},{95,8},{51,81},{78,79},{57,95}}));
		System.out.println(new Solution().minimumLines(new int[][] {{1,1},{500000000,499999999},{1000000000,999999998}}));
	}
}

class Solution {
    public int minimumLines(int[][] stockPrices) {
        if(stockPrices.length == 1) {
        	return 0;
        }
        Arrays.sort(stockPrices,(a,b)->a[0]-b[0]);
        int line = 1;
        double m1 = (double)((stockPrices[1][1] - stockPrices[0][1]) * 100) / (stockPrices[1][0] - stockPrices[0][0]);
        for(int i = 2; i < stockPrices.length; ++i) {
        	double m2 = (double)((stockPrices[i][1] - stockPrices[i - 1][1]) * 100) / (stockPrices[i][0] - stockPrices[i - 1][0]);
        	if(m1 != m2) {
        		line += 1;
        		m1 = m2;
        	}
        }
        return line;
    }
}


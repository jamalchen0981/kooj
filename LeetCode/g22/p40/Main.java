/**
 * 
 */
package g22.p40;

/**
 * LeetCode 2240. Number of Ways to Buy Pens and Pencils
 * Medium
 * 55 ms, 39.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().waysToBuyPensPencils(20, 10, 5));
		System.out.println(new Solution().waysToBuyPensPencils(5, 10, 10));
		System.out.println(new Solution().waysToBuyPensPencils(1000000, 1, 1));
	}
}

class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long result = 0;
        
        int x = total / cost1;
        
        for(int y = 0; y <= x; ++y) {
        	result += ((long)total - cost1 * y) / cost2 + 1;
        }
        
        return result;
    }
}


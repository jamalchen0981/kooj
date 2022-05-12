/**
 * 
 */
package g04.p41;

/**
 * LeetCode 441. Arranging Coins
 * Easy
 * 2 ms, 39.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().arrangeCoins(5));
		System.out.println(new Solution().arrangeCoins(8));
	}
}

class Solution {
    public int arrangeCoins(int n) {
    	long ans = 0L;
    	long lo = 1L, hi = 65535L;
    	while(lo <= hi) {
    		long mid = lo + (hi - lo) / 2;
    		long sum = (mid * (mid + 1)) / 2;
    		if(sum == n) {
    			return (int)mid;
    		}
    		
    		if(sum < n) {
    			ans = mid;
    			lo = mid + 1;
    		} else {
    			hi = mid - 1;
    		}
    	}
    	return (int)ans;
    }
}

/**
 * 
 */
package g03.p67;

/**
 * LeetCode 367. Valid Perfect Square
 * Easy
 * 0 ms, 38.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().isPerfectSquare(16));
		System.out.println(new Solution().isPerfectSquare(14));
		System.out.println(new Solution().isPerfectSquare(2147395600));
	}
}

class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = 65536;
        while(lo <= hi) {
        	long mid = lo + (hi - lo) / 2;
        	long value = mid * mid;
        	if(value == num) {
        		return true;
        	}
        	if(value < num) {
        		lo = mid + 1;
        	} else {
        		hi = mid - 1;
        	}
        }
        return false;
    }
}

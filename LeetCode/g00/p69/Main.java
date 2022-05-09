/**
 * 
 */
package g00.p69;

/**
 * LeetCode 69. Sqrt(x)
 * Easy
 * 3 ms, 41.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().mySqrt(4));
		System.out.println(new Solution().mySqrt(8));
	}
}

class Solution {
    public int mySqrt(int x) {
        long lo = 1, hi = 65536, mid = 0;
        int ret = 0;
        while(lo <= hi) {
        	mid = lo + (hi - lo) / 2;
        	long value = mid * mid;
        	if(value == x) {
        		return (int)mid;
        	}
        	
        	if(value < x) {
        		lo = mid + 1;
        	} else {
        		hi = mid - 1;
        		ret = (int)hi;
        	}
        }
        return ret;
    }
}


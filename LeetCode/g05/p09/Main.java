/**
 * 
 */
package g05.p09;

/**
 * LeetCode 509. Fibonacci Number
 * Easy
 * 0 ms, 41.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().fib(2));
		System.out.println(new Solution().fib(3));
		System.out.println(new Solution().fib(30));
	}
}

class Solution {
    public int fib(int n) {
        if(n == 0) {
        	return 0;
        }
        if(n == 1) {
        	return 1;
        }
        int pre2 = 0, pre1 = 1, v = -1;
        for(int i = 2; i <= n; ++i) {
        	v = pre2 + pre1;
        	pre2 = pre1;
        	pre1 = v;
        }
        return v;
    }
}

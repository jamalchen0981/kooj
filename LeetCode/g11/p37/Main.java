/**
 * 
 */
package g11.p37;

/**
 * LeetCode 1137. N-th Tribonacci Number
 * Easy
 * 0 ms, 41.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().tribonacci(4));
		System.out.println(new Solution().tribonacci(25));
		System.out.println(new Solution().tribonacci(37));
	}
}

class Solution {
    public int tribonacci(int n) {
        if(n == 0) {
        	return 0;
        }
        if(n == 1) {
        	return 1;
        }
        if(n == 2) {
        	return 1;
        }
        int pre3 = 0, pre2 = 1, pre1 = 1, v = 0;
        for(int i = 3; i <= n; ++i) {
        	v = pre3 + pre2 + pre1;
        	pre3 = pre2;
        	pre2 = pre1;
        	pre1 = v;
        }
        return v;
    }
}

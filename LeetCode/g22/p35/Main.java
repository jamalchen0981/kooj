/**
 * 
 */
package g22.p35;

/**
 * LeetCode 2235. Add Two Integers
 * Easy
 * 0 ms, 39.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().sum(12, 5));
		System.out.println(new Solution().sum(-10, 4));
	}
}

class Solution {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
}


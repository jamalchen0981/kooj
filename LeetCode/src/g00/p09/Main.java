/**
 * 
 */
package g00.p09;

/**
 * 9. Palindrome Number
 * Easy
 * 6ms, 38.2MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(121));
		System.out.println(new Solution().isPalindrome(-121));
		System.out.println(new Solution().isPalindrome(10));
		System.out.println(new Solution().isPalindrome(-101));
		System.out.println(new Solution().isPalindrome(1111));
		System.out.println(new Solution().isPalindrome(1001));
		System.out.println(new Solution().isPalindrome(9));
	}

}

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
        	return false;
        } else if(x < 10) {
        	return true;
        }
        int z = 0, y = x, prev = 0;
        while(z < y) {
        	prev = y;
        	z = z * 10 + (y % 10);
        	y /= 10;
        }
        return z == y || z == prev;
    }
}
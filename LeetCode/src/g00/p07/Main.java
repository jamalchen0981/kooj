/**
 * 
 */
package g00.p07;

/**
 * LeetCode 7. Reverse Integer
 * Easy
 * 1 ms, 36 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().reverse(123));
		System.out.println(new Solution().reverse(-123));
		System.out.println(new Solution().reverse(120));
		System.out.println(new Solution().reverse(0));
		System.out.println(new Solution().reverse(1234567899));
	}

}

class Solution {
    public int reverse(int x) {
    	long intMax = 2147483647;
    	long intMin = 2147483648L;
    	long value = 0;
        if(x > 0) {
        	while(x != 0) {
        		value = value * 10 + (x % 10);
        		x /= 10;
        	}
        	if(value > intMax) {
        		return 0;
        	}
        	return (int)value;
        } else if(x < 0) {
        	long y = -(long)x;
        	while(y != 0) {
        		value = value * 10 + (y % 10);
        		y /= 10;
        	}
        	if(value > intMin) {
        		return 0;
        	}
        	return (int)-value;
        }
        
        return 0;
    }
}
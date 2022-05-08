/**
 * 
 */
package g22.p64;

/**
 * LeetCode 2264. Largest 3-Same-Digit Number in String
 * Easy
 * 4ms, 44.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().largestGoodInteger("6777133339"));
		System.out.println(new Solution().largestGoodInteger("2300019"));
		System.out.println(new Solution().largestGoodInteger("42352338"));
	}
}

class Solution {
    public String largestGoodInteger(String num) {
    	String ans = "";
        for(int i = 0; i + 3 <= num.length(); ++i) {
        	String str = num.substring(i, i + 3);
        	if(str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)) {
        		if(str.compareTo(ans) > 0) {
        			ans = str;
        		}
        	}
        }
        return ans;
    }
}


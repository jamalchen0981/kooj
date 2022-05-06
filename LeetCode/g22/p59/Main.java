/**
 * 
 */
package g22.p59;

/**
 * LeetCode 2259. Remove Digit From Number to Maximize Result
 * Easy
 * 3ms, 43.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().removeDigit("123", '3'));
		System.out.println(new Solution().removeDigit("1231", '1'));
		System.out.println(new Solution().removeDigit("551", '5'));
	}
}

class Solution {
    public String removeDigit(String number, char digit) {
    	String ret = "";
        for(int i = 0; i < number.length(); ++i) {
        	if(number.charAt(i) == digit) {
        		String str = "";
        		if(0 < i) {
        			str += number.substring(0, i);
        		}
        		if(i + 1 < number.length()) {
        			str += number.substring(i + 1);
        		}
        		if(str.compareTo(ret) > 0) {
        			ret = str;
        		}
        	}
        }
        return ret;
    }
}


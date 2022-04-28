/**
 * 
 */
package g22.p43;

/**
 * LeetCode 2243. Calculate Digit Sum of a String
 * Easy
 * 4 ms, 42.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().digitSum("11111222223", 3));
		System.out.println(new Solution().digitSum("00000000", 3));

	}
}

class Solution {
    public String digitSum(String s, int k) {
    	String str = s;
    	while(str.length() > k) {
    		str = round(str, k);
    	}
    	return str;
    }
    
    private String round(String str, int k) {
    	String newStr = "";
    	for(int i = 0; i < str.length(); i += k) {
    		if(i + k <= str.length()) {
    			String s = str.substring(i, i + k);
    			int sum = 0;
    			for(int j = 0; j < s.length(); ++j) {
    				sum += s.charAt(j) - '0';
    			}
    			newStr += String.valueOf(sum);
    		} else {
    			String s = str.substring(i, str.length());
    			int sum = 0;
    			for(int j = 0; j < s.length(); ++j) {
    				sum += s.charAt(j) - '0';
    			}
    			newStr += String.valueOf(sum);
    		}
    	}
    	return newStr;
    }
}


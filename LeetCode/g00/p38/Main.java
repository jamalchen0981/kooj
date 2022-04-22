/**
 * 
 */
package g00.p38;

/**
 * LeetCode 38. Count and Say
 * Medium
 * 41 ms, 64.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().countAndSay(1));
		System.out.println(new Solution().countAndSay(2));
		System.out.println(new Solution().countAndSay(3));
		System.out.println(new Solution().countAndSay(4));
		System.out.println(new Solution().countAndSay(30));
	}
}

class Solution {
    public String countAndSay(int n) {
    	String str = "1";
    	if(n == 1) {
    		return str;
    	}
        for(int i = 2; i <= n; ++i) {
    		String nextStr = "";
    		int count = 0;
    		char c = 'a';
    		for(int j = 0; j < str.length(); ++j) {
    			if(j == 0) {
    				count = 1;
    				c = str.charAt(j);
    			} else if(str.charAt(j) == c) {
    				count += 1;
    			} else {
    				nextStr += String.valueOf(count) + String.valueOf(c);
    				c = str.charAt(j);
    				count = 1;
    			}
    		}
    		nextStr += String.valueOf(count) + String.valueOf(c);
    		str = nextStr;
        }
        return str;
    }
}


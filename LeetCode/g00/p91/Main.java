/**
 * 
 */
package g00.p91;

import java.util.Arrays;

/**
 * LeetCode 91. Decode Ways
 * Medium
 * 4 ms, 42.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().numDecodings("12"));
		System.out.println(new Solution().numDecodings("226"));
		System.out.println(new Solution().numDecodings("06"));
	}
}

class Solution {
    public int numDecodings(String s) {
        int[] ary = new int[s.length() + 1];
        Arrays.fill(ary, 0);
        ary[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0; --i) {
        	if(i + 1 <= s.length()) {
	        	String sub = s.substring(i, i + 1);
	        	if(!sub.startsWith("0")) {
	        		int x = Integer.parseInt(sub);
	        		if(x >= 1 && x <= 26) {
	        			ary[i] += ary[i + 1];
	        		}
	        	}
        	}
        	if(i + 2 <= s.length()) {
	        	String sub = s.substring(i, i + 2);
	        	if(!sub.startsWith("0")) {
	        		int x = Integer.parseInt(sub);
	        		if(x >= 1 && x <= 26) {
	        			ary[i] += ary[i + 2];
	        		}
	        	}
        	}
        }
        return ary[0];
    }
}


/**
 * 
 */
package g22.p66;

import java.util.Arrays;

/**
 * LeetCode 2266. Count Number of Texts
 * Medium
 * 39ms, 52.8 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().countTexts("22233"));
		System.out.println(new Solution().countTexts("222222222222222222222222222222222222"));
		System.out.println(new Solution().countTexts("344644885"));
	}
}

class Solution {
    public int countTexts(String pressedKeys) {
    	int mod = 1000000007;
        int[] ary = new int[pressedKeys.length() + 1];
        Arrays.fill(ary, 0);
        ary[pressedKeys.length()] = 1;
        for(int i = pressedKeys.length() - 1; i >= 0; --i) {
        	char c = pressedKeys.charAt(i);
        	ary[i] = (ary[i] + ary[i + 1]) % mod;
        	if(c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '8') {
        		if(i + 1 < pressedKeys.length() && pressedKeys.charAt(i + 1) == c) {
        			ary[i] = (ary[i] + ary[i + 2]) % mod;
        			
        			if(i + 2 < pressedKeys.length() && pressedKeys.charAt(i + 2) == c) {
            			ary[i] = (ary[i] + ary[i + 3]) % mod;
            		}
        		}
        	} else if(c == '7' || c == '9') {
        		if(i + 1 < pressedKeys.length() && pressedKeys.charAt(i + 1) == c) {
        			ary[i] = (ary[i] + ary[i + 2]) % mod;
        			
        			if(i + 2 < pressedKeys.length() && pressedKeys.charAt(i + 2) == c) {
            			ary[i] = (ary[i] + ary[i + 3]) % mod;
            			
            			if(i + 3 < pressedKeys.length() && pressedKeys.charAt(i + 3) == c) {
                			ary[i] = (ary[i] + ary[i + 4]) % mod;
                		}
            		}
        		}
        	}
        }
        return ary[0];
    }
}
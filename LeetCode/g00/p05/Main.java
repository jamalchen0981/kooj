/**
 * 
 */
package g00.p05;

/**
 * LeetCode 5. Longest Palindromic Substring
 * Medium
 * 111 ms, 42.9 MB
 * Dynamic Programming
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("babad"));
		System.out.println(new Solution().longestPalindrome("cbbd"));
		System.out.println(new Solution().longestPalindrome("a"));
		System.out.println(new Solution().longestPalindrome("ac"));
	}

}

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int x = 0, max = 0;
        
        max = 1;
        for (int i = 0; i < n; ++i) { 
            dp[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; ++i) {
        	if(s.charAt(i) == s.charAt(i + 1)) {
        		dp[i][i + 1] = true;
        		x = i;
        		max = 2;
        	}
        }
        
        for(int k = 3; k <= n; ++k) {
        	for(int i = 0; i < n - k + 1; ++i) {
        		int j = i + k - 1;
        		if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
        			dp[i][j] = true;
        			
        			if(k > max) {
        				x = i;
        				max = k;
        			}
        		}
        	}
        }
        
        return s.substring(x, x + max);
    }
}

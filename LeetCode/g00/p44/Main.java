/**
 * 
 */
package g00.p44;

/**
 * LeetCode 44. Wildcard Matching
 * Hard
 * 76 ms, 54.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().isMatch("aa", "a"));
		System.out.println(new Solution().isMatch("aa", "*"));
		System.out.println(new Solution().isMatch("cb", "?a"));
		System.out.println(new Solution().isMatch("cbacbb", "*cbb"));
		System.out.println(new Solution().isMatch("cbacbba", "*cbb*"));
		System.out.println(new Solution().isMatch("adceb", "*a*b"));
	}
}

class Solution {
	Boolean[][] dp;
    public boolean isMatch(String s, String p) {
    	dp = new Boolean[s.length()][p.length()];
    	return func(s, p, s.length() - 1, p.length() - 1);
    }
    
    private boolean func(String s, String p, int n, int m) {
    	if(n == -1 && m == -1) {
    		return true;
    	}
    	if(n < 0) {
    		for(int i = 0; i <= m; ++i) {
    			if(p.charAt(i) != '*') {
    				return false;
    			}
    		}
    		return true;
    	}
    	if(m < 0) {
    		return false;
    	}
    	if(dp[n][m] != null) {
    		return dp[n][m];
    	}
    	if(p.charAt(m) == '?' || s.charAt(n) == p.charAt(m)) {
    		dp[n][m] = func(s, p, n - 1, m - 1);
    		return dp[n][m];
    	}
    	if(p.charAt(m) == '*') {
    		dp[n][m] = func(s, p, n - 1, m) || func(s, p, n, m - 1);
    		return dp[n][m];
    	}
    	dp[n][m] = false;
    	return dp[n][m];
    }
}


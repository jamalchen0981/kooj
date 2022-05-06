/**
 * 
 */
package g22.p62;

/**
 * LeetCode 2262. Total Appeal of A String
 * Hard
 * 16ms, 52.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().appealSum("abbca"));
		System.out.println(new Solution().appealSum("code"));
	}
}

class Solution {
    public long appealSum(String s) {
    	long sum = 0L;
    	int[] count = new int[26];
    	for(int i = 0; i < 26; ++i) {
    		count[i] = -1;
    	}
    	int[] dp = new int[s.length() + 1];
    	dp[0] = 1;
    	count[s.charAt(0) - 'a'] = 0;
        for(int i = 1; i < s.length(); ++i) {
        	dp[i] = dp[i - 1] + i - count[s.charAt(i) - 'a'];
        	sum += dp[i];
        	
        	count[s.charAt(i) - 'a'] = i;
        }
        return sum + 1;
    }
}


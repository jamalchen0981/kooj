/**
 * 
 */
package g00.p32;

/**
 * LeetCode 32. Longest Valid Parentheses
 * Hard
 * 2 ms, 38.8 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().longestValidParentheses("(()()(())(("));
		System.out.println(new Solution().longestValidParentheses(")("));
		System.out.println(new Solution().longestValidParentheses("(())"));
		System.out.println(new Solution().longestValidParentheses("()(()"));
		System.out.println(new Solution().longestValidParentheses("(()"));
		System.out.println(new Solution().longestValidParentheses(")()())"));
		System.out.println(new Solution().longestValidParentheses(""));
		System.out.println(new Solution().longestValidParentheses(")()())()()()"));
	}
}

class Solution {
	
    public int longestValidParentheses(String s) {
        if(s.length() > 0) {
        	int[] index = new int[40000];
        	int x = 0;
        	int y = 0;
        	int max = 0;
    		for(int i = y; i < s.length(); ++i) {
    			char c = s.charAt(i);
    			if(c == '(') {
    				index[x] = i;
    				++x;
    			} else {
    				--x;
    				if(x < 0) {
    					y = i + 1;
    					x = 0;
    				} else {
    					if(x > 0) {
    						if(max < i - index[x - 1]) {
    							max = i - index[x - 1];
    						}
    					} else {
    						if(max < i - y + 1) {
    							max = i - y + 1;
    						}
    					}
    				}
    			}
    		}
    		if(x - 1 >= 0) {
    			y = index[x - 1] + 1;
    		}
    		if(max < s.length() - y) {
    			max = s.length() - y;
    		}
    		return max;
        }
        return 0;
    }
}


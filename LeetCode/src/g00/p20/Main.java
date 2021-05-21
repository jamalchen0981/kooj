/**
 * 
 */
package g00.p20;

/**
 * LeetCode 20. Valid Parentheses
 * Easy
 * 1 ms, 40.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().isValid("()"));
		System.out.println(new Solution().isValid("()[]{}"));
		System.out.println(new Solution().isValid("(]"));
		System.out.println(new Solution().isValid("([)]"));
		System.out.println(new Solution().isValid("{[]}"));
	}

}

class Solution {	
    public boolean isValid(String s) {
        char[] ary = new char[10010];
        int pt = 0;
        
        for(int i = 0; i < s.length(); ++i) {
        	char c = s.charAt(i);
        	
        	if(c == '(') {
        		ary[pt++] = ')';
        	} else if(c == '[') {
        		ary[pt++] = ']';
        	} else if(c == '{') {
        		ary[pt++] = '}';
        	} else {
        		pt -= 1;
        		if(!(pt >= 0 && ary[pt] == c)) {
        			return false;
        		}
        	}
        }
        
        return pt == 0;
    }
}


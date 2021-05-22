/**
 * 
 */
package g00.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 22. Generate Parentheses
 * Medium
 * 1 ms, 38.9 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().generateParenthesis(3));
		System.out.println(new Solution().generateParenthesis(1));
	}

}

class Solution {
	
	private List<String> answer = new ArrayList<String>();
	
    public List<String> generateParenthesis(int n) {
    	String s = "";
        gen(s, n, 0, 0);
        
        return answer;
    }
    
    private void gen(String s, int n, int x, int y) {
    	if(x < n && x >= y) {
    		gen(s + "(", n, x + 1, y);
    	}
    	if(y < n && y < x) {
    		gen(s + ")", n, x, y + 1);
    	}
    	if(x == n && y == n) {
    		answer.add(s);
    	}
    }
}


/**
 * 
 */
package g00.p17;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Medium
 * 0 ms, 37.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("23"));
		System.out.println(new Solution().letterCombinations(""));
		System.out.println(new Solution().letterCombinations("2"));
	}

}

class Solution {	
    public List<String> letterCombinations(String digits) {
    	
    	char[][] nums = new char[][] {
    		{}, // 0
    		{}, // 1
    		{'a', 'b', 'c'}, // 2
    		{'d', 'e', 'f'}, // 3
    		{'g', 'h', 'i'}, // 4
    		{'j', 'k', 'l'}, // 5
    		{'m', 'n', 'o'}, // 6
    		{'p', 'q', 'r', 's'}, // 7
    		{'t', 'u', 'v'}, // 8
    		{'w', 'x', 'y', 'z'} // 9
    		};
    	
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if(digits.length() > 0) {
        	recursive(nums, digits, 0, sb, list);
        }
        
        return list;
    }
    
    private void recursive(char[][] nums, String digits, int index, StringBuilder last_sb, List<String> list) {
    	if(index < digits.length()) {
    		char c = digits.charAt(index);
    		int x = c - '0';
    		for(int i = 0; i < nums[x].length; ++i) {
    			StringBuilder sb = new StringBuilder(last_sb);
    			sb.append(nums[x][i]);
    			recursive(nums, digits, index + 1, sb, list);
    		}
    	} else {
    		list.add(last_sb.toString());
    	}
    }
}


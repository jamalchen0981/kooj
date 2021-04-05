/**
 * 
 */
package g00.p14;

/**
 * 14. Longest Common Prefix
 * Easy
 * 0 ms, 36.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(new Solution().longestCommonPrefix(new String[] {"dog","racecar","car"}));
		System.out.println(new Solution().longestCommonPrefix(new String[] {"dog"}));
		System.out.println(new Solution().longestCommonPrefix(new String[] {"dog", "do"}));
	}

}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        
        if(strs.length > 0) {
        	int minLen = 200;
        	for(int i = 0; i < strs.length; ++i) {
        		if(minLen > strs[i].length()) {
        			minLen = strs[i].length();
        		}
        	}
	        boolean flag = true;
	        for(int i = 0; i < minLen; ++i) {
	        	char c = strs[0].charAt(i);
	        	for(int j = 1; j < strs.length; ++j) {
	        		if(c != strs[j].charAt(i)) {
	        			flag = false;
	        			break;
	        		}
	        	}
	        	if(flag) {
	        		sb.append(c);
	        	} else {
	        		break;
	        	}
	        }
        }
        
        return sb.toString();
    }
}


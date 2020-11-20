/**
 * 
 */
package g00.p03;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * 2ms, 39MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
		System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
		System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
		System.out.println(new Solution().lengthOfLongestSubstring(""));
	}

}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] x = new int[256];
        for(int i = 0; i < x.length; ++i) {
        	x[i] = -1;
        }
        int max = 0;
        int pivot = 0;
        for(int i = 0; i < s.length(); ++i) {
        	char c = s.charAt(i);
        	if(x[c] >= 0 && x[c] >= pivot) {
        		if(max < i - pivot) {
        			max = i - pivot;
        		}
        		pivot = x[c] + 1;
        	}
        	x[c] = i;
        }
        if(max < s.length() - pivot) {
        	max = s.length() - pivot;
        }
        return max;
    }
}

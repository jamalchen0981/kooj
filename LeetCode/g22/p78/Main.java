/**
 * 
 */
package g22.p78;

import java.util.Arrays;

/**
 * LeetCode 2278. Percentage of Letter in String
 * Easy
 * 1 ms, 42.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().percentageLetter("foobar", 'o'));
		System.out.println(new Solution().percentageLetter("jjjj", 'k'));
	}
}

class Solution {
    public int percentageLetter(String s, char letter) {
        int[] ary = new int[26];
        Arrays.fill(ary, 0);
        for(int i = 0; i < s.length(); ++i) {
        	ary[s.charAt(i) - 'a'] += 1;
        }
        return (int)((100.0 * ary[letter - 'a']) / s.length());
    }
}


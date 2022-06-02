/**
 * 
 */
package g22.p87;

import java.util.Arrays;

/**
 * LeetCode 2287. Rearrange Characters to Make Target String
 * Easy
 * 2 ms, 42.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().rearrangeCharacters("ilovecodingonleetcode", "code"));
		System.out.println(new Solution().rearrangeCharacters("abcba", "abc"));
	}
}

class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] ary = new int[26];
        Arrays.fill(ary, 0);
        for(int i = 0; i < s.length(); ++i) {
        	ary[s.charAt(i) - 'a'] += 1;
        }
        int[] ary2 = new int[26];
        Arrays.fill(ary2, 0);
        for(int i = 0; i < target.length(); ++i) {
        	ary2[target.charAt(i) - 'a'] += 1;
        }
        int ret = 0;
        boolean flag = true;
        while(flag) {
        	for(int i = 0; i < 26; ++i) {
        		if(ary[i] >= ary2[i]) {
        			ary[i] -= ary2[i];
        		} else {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) {
        		ret += 1;
        	}
        }
        return ret;
    }
}


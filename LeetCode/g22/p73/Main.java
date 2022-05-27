/**
 * 
 */
package g22.p73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 2273. Find Resultant Array After Removing Anagrams
 * Easy
 * 4 ms, 43.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new Solution().removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"});
		for(String s : list) {
			System.out.println(s);
		}
	}
}

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> str = new ArrayList<>();
        for(int i = 0; i < words.length; ++i) {
        	str.add(words[i]);
        }
        boolean found = true;
        while(found) {
        	found = false;
        	for(int i = 1; i < str.size(); ++i) {
        		String str1 = str.get(i);
        		String str2 = str.get(i - 1);
        		
        		if(str1.length() == str2.length()) {
	        		int[] ary = new int[26];
	        		Arrays.fill(ary, 0);
	        		int[] ary2 = new int[26];
	        		Arrays.fill(ary2, 0);
	        		
	        		for(int m = 0; m < str1.length(); ++m) {
	        			ary[str1.charAt(m) - 'a'] += 1;
	        		}
	        		for(int m = 0; m < str2.length(); ++m) {
	        			ary2[str2.charAt(m) - 'a'] += 1;
	        		}
	        		
	        		boolean same = true;
	        		for(int m = 0; m < 26; ++m) {
	        			if(ary[m] != ary2[m]) {
	        				same = false;
	        				break;
	        			}
	        		}
	        		if(same) {
	        			found = true;
	        			str.remove(i);
	        			break;
	        		}
        		}
        	}
        }
        return str;
    }
}

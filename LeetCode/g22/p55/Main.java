/**
 * 
 */
package g22.p55;

/**
 * LeetCode 2255. Count Prefixes of a Given String
 * Easy
 * 0 ms, 42.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().countPrefixes(new String[] {"a","b","c","ab","bc","abc"}, "abc"));
		System.out.println(new Solution().countPrefixes(new String[] {"a","a"}, "aa"));
	}
}

class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for(int i = 0; i < words.length; ++i) {
        	if(s.startsWith(words[i])) {
        		count += 1;
        	}
        }
        return count;
    }
}


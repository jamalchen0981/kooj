/**
 * 
 */
package g00.p28;

/**
 * LeetCode 28. Implement strStr()
 * Easy
 * 3 ms, 38.5 MB
 * 
 * Knuth–Morris–Pratt algorithm
 * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().strStr("hello", "ll"));
		System.out.println(new Solution().strStr("aaaaa", "bba"));
		System.out.println(new Solution().strStr("", ""));
		System.out.println(new Solution().strStr("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));
	}

}

class Solution {
	
    public int strStr(String haystack, String needle) {
        if("".equals(needle)) {
        	return 0;
        }
        int[] T = new int[needle.length() + 1];
        int pos = 1, cnd = 0;
        T[0] = -1;
        while(pos < needle.length()) {
        	if(needle.charAt(pos) == needle.charAt(cnd)) {
        		T[pos] = T[cnd];
        	} else {
        		T[pos] = cnd;
        		while(cnd >= 0 && needle.charAt(pos) != needle.charAt(cnd)) {
        			cnd = T[cnd];
        		}
        	}
        	pos += 1;
        	cnd += 1;
        }
        T[pos] = cnd;
        int j = 0, k = 0;
        while(j < haystack.length()) {
        	if(needle.charAt(k) == haystack.charAt(j)) {
        		j += 1;
        		k += 1;
        		if(k == needle.length()) {
        			return j - k;
        		}
        	} else {
        		k = T[k];
        		if(k < 0) {
        			j += 1;
        			k += 1;
        		}
        	}
        }
        return -1;
    }
}


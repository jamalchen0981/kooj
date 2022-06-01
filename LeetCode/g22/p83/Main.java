/**
 * 
 */
package g22.p83;

import java.util.Arrays;

/**
 * LeetCode 2283. Check if Number Has Equal Digit Count and Digit Value
 * Easy
 * 2 ms, 42.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().digitCount("1210"));
		System.out.println(new Solution().digitCount("030"));
	}
}

class Solution {
    public boolean digitCount(String num) {
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for(int i = 0; i < num.length(); ++i) {
        	count[num.charAt(i) - '0'] += 1;
        }
        for(int i = 0; i < num.length(); ++i) {
        	int j = num.charAt(i) - '0';
        	if(count[i] != j) {
        		return false;
        	}
        }
        return true;
    }
}


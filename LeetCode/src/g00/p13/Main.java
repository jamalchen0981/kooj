/**
 * 
 */
package g00.p13;

/**
 * 13. Roman to Integer
 * Easy
 * 3 ms, 39 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().romanToInt("III"));
		System.out.println(new Solution().romanToInt("IV"));
		System.out.println(new Solution().romanToInt("IX"));
		System.out.println(new Solution().romanToInt("LVIII"));
		System.out.println(new Solution().romanToInt("MCMXCIV"));
		System.out.println(new Solution().romanToInt("MMMCMXCIX"));
	}

}

class Solution {
	public int romanToInt(String s) {
        char[] array = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] array_i = new int[] {1000, 500, 100, 50, 10, 5, 1};
        
        int num = 0, x = 0;
        for(int i = 0; i < s.length(); ++i) {
        	char c = s.charAt(i);
        	for(int j = 0; j < array.length; ++j) {
        		if(c == array[j]) {
        			if(j < x) {
        				num = num - array_i[x] + array_i[j] - array_i[x];
        			} else {
        				num += array_i[j];
        			}
        			x = j;
        			break;
        		}
        	}
        }
        return num;
    }
}


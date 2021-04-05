/**
 * 
 */
package g00.p12;

/**
 * 12. Integer to Roman
 * Medium
 * 3 ms, 38.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(3));
		System.out.println(new Solution().intToRoman(4));
		System.out.println(new Solution().intToRoman(9));
		System.out.println(new Solution().intToRoman(58));
		System.out.println(new Solution().intToRoman(1994));
		System.out.println(new Solution().intToRoman(3999));
	}

}

class Solution {
    public String intToRoman(int num) {
        String[] array = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] array_i = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
        	for(int i = 0; i < array_i.length; ++i) {
        		if(num >= array_i[i]) {
        			sb.append(array[i]);
        			num -= array_i[i];
        			break;
        		}
        	}
        }
        return sb.toString();
    }
}


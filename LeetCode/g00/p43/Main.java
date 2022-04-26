/**
 * 
 */
package g00.p43;

/**
 * LeetCode 43. Multiply Strings
 * Medium
 * 13 ms, 44.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().multiply("2", "3"));
		System.out.println(new Solution().multiply("123", "456"));
		System.out.println(new Solution().multiply("9", "9"));
	}
}

class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
        	return "0";
        }
        if("1".equals(num1)) {
        	return num2;
        }
        if("1".equals(num2)) {
        	return num1;
        }
        int[] array = new int[num1.length() + num2.length()];
        for(int i = 0; i < array.length; ++i) {
        	array[i] = 0;
        }
        int last = array.length - 1;
        for(int i = num1.length() - 1; i >= 0; --i, --last) {
        	int x = last;
        	for(int j = num2.length() - 1; j >= 0; --j, --x) {
        		int p = num1.charAt(i) - '0';
        		int q = num2.charAt(j) - '0';
        		int m = p * q;
        		int r = m % 10;
        		int a = m / 10;
        		array[x] += r;
        		array[x - 1] += a;
        	}
        }
        String ans = "";
        for(int i = array.length - 1; i >= 1; --i) {
        	int r = array[i] % 10;
        	int a = array[i] / 10;
        	array[i] = r;
        	array[i - 1] += a;
        	ans = array[i] + ans;
        }
        ans = array[0] + ans;
        while(ans.length() > 1 && ans.startsWith("0")) {
        	ans = ans.substring(1);
        }
        return ans;
    }
}


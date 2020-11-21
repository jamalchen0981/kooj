/**
 * 
 */
package g00.p06;

/**
 * 6. ZigZag Conversion
 * Medium
 * 2ms, 39.2MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().convert("PAYPALISHIRING", 3));
		System.out.println(new Solution().convert("PAYPALISHIRING", 4));
		System.out.println(new Solution().convert("A", 1));
		System.out.println(new Solution().convert("AB", 1));
	}

}

class Solution {
    public String convert(String s, int numRows) {
    	if(numRows == 1) {
    		return s;
    	}
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numRows && i < s.length(); ++i) {
        	sb.append(s.charAt(i));
        	int x = ((numRows - 2) - i) * 2 + 2;
        	int y = i * 2;
        	int k = i;
        	while(x > 0 || y > 0) {
        		if(x > 0) {
	        		k += x;
	        		if(k < s.length()) {
	        			sb.append(s.charAt(k));
	        		} else {
	        			break;
	        		}
        		}
        		if(y > 0) {
	        		k += y;
	        		if(k < s.length()) {
	        			sb.append(s.charAt(k));
	        		} else {
	        			break;
	        		}
        		}
        	}
        }
        
        return sb.toString();
    }
}
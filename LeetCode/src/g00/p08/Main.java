/**
 * 
 */
package g00.p08;

/**
 * LeetCode 8. String to Integer (atoi)
 * Medium
 * 1 ms, 38.8 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().myAtoi("42"));
		System.out.println(new Solution().myAtoi("   -42"));
		System.out.println(new Solution().myAtoi("4193 with words"));
		System.out.println(new Solution().myAtoi("words and 987"));
		System.out.println(new Solution().myAtoi("-91283472332"));
		System.out.println(new Solution().myAtoi("-002147483648"));
		System.out.println(new Solution().myAtoi("0000000000000000000"));
	}

}

class Solution {
    public int myAtoi(String s) {
    	int n = s.length(), pivot = n;
        for(int i = 0; i < n; ++i) {
        	if(s.charAt(i) != ' ') {
        		pivot = i;
        		break;
        	}
        }
        if(pivot < n) {
        	boolean neg = false;
        	if(s.charAt(pivot) == '-') {
        		pivot += 1;
        		neg = true;
        	} else if(s.charAt(pivot) == '+') {
        		pivot += 1;
        	}
        	if(pivot < n && Character.isDigit(s.charAt(pivot))) {
        		int begin = n;
        		for(int i = pivot; i < n; ++i) {
                	if(s.charAt(i) != '0') {
                		begin = i;
                		break;
                	}
                }
        		pivot = begin;
                if(pivot < n && Character.isDigit(s.charAt(pivot))) {
    				long x = 0;
    				for(int i = pivot; i < n; ++i) {
    					if(Character.isDigit(s.charAt(i))) {
    						x = x * 10 + (s.charAt(i) - '0');
    						if(neg) {
    	    					if(-x < Integer.MIN_VALUE) {
    	    						return Integer.MIN_VALUE;
    	    					}
    						} else {
    							if(x > Integer.MAX_VALUE) {
    		    					return Integer.MAX_VALUE;
    		    				}
    						}
    					} else {
    						break;
    					}
    				}
    				if(neg) {
    					return (int)-x;
    				}
    				return (int)x;
                }
        	}
        }
        return 0;
    }
}

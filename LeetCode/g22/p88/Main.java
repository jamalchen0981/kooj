/**
 * 
 */
package g22.p88;

/**
 * LeetCode 2288. Apply Discount to Prices
 * Medium
 * 2582 ms, 637 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
		System.out.println(new Solution().discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
	}
}

class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] ary = sentence.split("\\s+");
        for(int i = 0; i < ary.length; ++i) {
        	String s = ary[i];
        	if(s.charAt(0) == '$') {
        		String s2 = s.substring(1);
        		if(check(s2)) {
	        		try {
	        			
	        			double d = Double.parseDouble(s2);
	        			
	        			int a = 100 - discount;
	        			d *= a / 100.0;
	        			
	        			String s3 = String.format("%.2f", d);
	        			
	        			ary[i] = "$" + s3;
	        		} catch(Exception e) {
	        			
	        		}
        		}
        	}
        }
        
        String str = "";
        for(int i = 0; i < ary.length; ++i) {
        	str += ary[i] + " ";
        }
        str = str.trim();
        return str;
    }
    
    private boolean check(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!(c == '.' || (c >= '0' && c <= '9'))) {
            	return false;
            }
        }

        return true;
    }
}


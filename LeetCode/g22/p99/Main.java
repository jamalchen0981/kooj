/**
 * 
 */
package g22.p99;

/**
 * LeetCode 2299. Strong Password Checker II
 * Easy
 * 1 ms, 42.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().strongPasswordCheckerII("IloveLe3tcode!"));
		System.out.println(new Solution().strongPasswordCheckerII("Me+You--IsMyDream"));
	}
}

class Solution {
    public boolean strongPasswordCheckerII(String password) {
    	
        if(!(password != null && password.length() >= 8)) {
        	return false;
        }
        
        String sc = "!@#$%^&*()-+";
        char ch, ch2;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialCharacterFlag = false;
        for(int i = 0; i < password.length(); ++i) {
        	ch = password.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else if(sc.indexOf(ch) >= 0) {
            	specialCharacterFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag && specialCharacterFlag) {
                break;
            }
        }
        if(!(numberFlag && capitalFlag && lowerCaseFlag && specialCharacterFlag)) {
            return false;
        }
        
        for(int i = 0; i < password.length(); ++i) {
        	if(i > 0) {
        		ch = password.charAt(i - 1);
        		ch2 = password.charAt(i);
        		if(ch == ch2) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
}

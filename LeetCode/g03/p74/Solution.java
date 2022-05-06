/**
 * 
 */
package g03.p74;

/**
 * LeetCode 374. Guess Number Higher or Lower
 * Easy
 * 0 ms, 39.1 MB
 * 
 * @author jamal
 *
 */
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        int mid = -1;
        while(true) {
	        mid = lo +  (hi - lo) / 2;
	        int v = guess(mid);
	        if(v == -1) {
	        	hi = mid - 1;
	        } else if(v == 1) {
	        	lo = mid + 1;
	        } else {
	        	break;
	        }
        }
        return mid;
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().guessNumber(2126753390));
	}
}

class GuessGame {
	/** 
	 * Forward declaration of guess API.
	 * @param  num   your guess
	 * @return 	     -1 if num is higher than the picked number
	 *			      1 if num is lower than the picked number
	 *               otherwise return 0
	 * int guess(int num);
	 */
	int value = 1702766719;
	
	int guess(int num) {
		if(num > value) {
			return -1;
		} else if(num < value) {
			return 1;
		}
		return 0;
	}
}

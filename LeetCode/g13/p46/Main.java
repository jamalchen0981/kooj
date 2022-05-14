/**
 * 
 */
package g13.p46;

import java.util.Arrays;

/**
 * LeetCode 1346. Check If N and Its Double Exist
 * Easy
 * 4 ms, 44.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().checkIfExist(new int[] {10,2,5,3}));
		System.out.println(new Solution().checkIfExist(new int[] {7,1,14,11}));
		System.out.println(new Solution().checkIfExist(new int[] {3,1,7,11}));
	}
}

class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean[] positive = new boolean[2002];
        boolean[] negative = new boolean[2002];
        Arrays.fill(positive, false);
        Arrays.fill(negative, false);
        int countZero = 0;
        for(int i = 0; i < arr.length; ++i) {
        	if(arr[i] == 0) {
        		countZero += 1;
        	} else if(arr[i] > 0) {
        		positive[arr[i]] = true;
        	} else {
        		negative[-arr[i]] = true;
        	}
        }
        if(countZero > 1) {
        	return true;
        }
        for(int i = 0; i < 1001; ++i) {
        	if(positive[i] && positive[i + i]) {
        		return true;
        	}
        }
        for(int i = 0; i < 1001; ++i) {
        	if(negative[i] && negative[i + i]) {
        		return true;
        	}
        }
        return false;
    }
}

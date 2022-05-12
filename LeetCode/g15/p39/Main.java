/**
 * 
 */
package g15.p39;

/**
 * LeetCode 1539. Kth Missing Positive Number
 * Easy
 * 1 ms, 43.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().findKthPositive(new int[] {2,3,4,7,11}, 5));
		System.out.println(new Solution().findKthPositive(new int[] {1,2,3,4}, 2));
	}
}

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0, index = 0;
        for(int i = 1; ; ++i) {
        	if(i == arr[index]) {
        		index += 1;
        		if(index == arr.length) {
        			return i + k - missing;
        		}
        	} else {
        		missing += 1;
        		if(missing == k) {
        			return i;
        		}
        	}
        }
    }
}

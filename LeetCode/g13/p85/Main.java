/**
 * 
 */
package g13.p85;

/**
 * LeetCode 1385. Find the Distance Value Between Two Arrays
 * Easy
 * 5 ms, 44.9 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().findTheDistanceValue(new int[] {4,5,8}, new int[] {10,9,1,8}, 2));
		System.out.println(new Solution().findTheDistanceValue(new int[] {1,4,2,3}, new int[] {-4,-3,6,10,20,30}, 3));
	}
}

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    	int count = 0;
        for(int i = 0; i < arr1.length; ++i) {
        	int j = 0;
        	for(; j < arr2.length; ++j) {
        		if(Math.abs(arr1[i] - arr2[j]) <= d) {
        			break;
        		}
        	}
        	if(j == arr2.length) {
        		count += 1;
        	}
        }
        return count;
    }
}

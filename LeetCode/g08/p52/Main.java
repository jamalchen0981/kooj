/**
 * 
 */
package g08.p52;

/**
 * LeetCode 852. Peak Index in a Mountain Array
 * Easy
 * 0 ms, 42.3 MB
 * 
 * @author jamal
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(new Solution().peakIndexInMountainArray(new int[] {0,1,0}));
		System.out.println(new Solution().peakIndexInMountainArray(new int[] {0,2,1,0}));
		System.out.println(new Solution().peakIndexInMountainArray(new int[] {0,10,5,2}));
	}
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
        	if(arr[i] > arr[i + 1]) {
        		return i;
        	}
        }
        return -1;
    }
}

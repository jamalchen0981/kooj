/**
 * 
 */
package g00.p35;

/**
 * LeetCode 35. Search Insert Position
 * Easy
 * 0 ms, 44.5 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(new Solution().searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(new Solution().searchInsert(new int[] {1,3,5,6}, 7));
	}
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int index = -1;
        while(lo <= hi) {
        	int mid = lo + (hi - lo) / 2;
        	if(nums[mid] == target) {
        		hi = mid - 1;
        	}
        	
        	if(nums[mid] < target) {
        		lo = mid + 1;
        	} else {
        		hi = mid - 1;
        	}
        	index = lo;
        }
        return index;
    }
}


/**
 * 
 */
package g07.p04;

/**
 * LeetCode 704. Binary Search
 * Easy
 * 0 ms, 54.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().search(new int[] {-1,0,3,5,9,12}, 9));
		System.out.println(new Solution().search(new int[] {-1,0,3,5,9,12}, 2));
	}
}

class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
        	int mid = lo + (hi - lo) / 2;
        	if(target == nums[mid]) {
        		index = mid;
        		break;
        	}
        	if(target > nums[mid]) {
        		lo = mid + 1;
        	} else {
        		hi = mid - 1;
        	}
        }
        return index;
    }
}

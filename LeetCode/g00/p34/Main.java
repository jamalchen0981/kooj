/**
 * 
 */
package g00.p34;

/**
 * LeetCode 34. Find First and Last Position of Element in Sorted Array
 * Medium
 * 0 ms, 47.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ans = new int[2];
		ans = new Solution().searchRange(new int[] {5,7,7,8,8,10}, 8);
		System.out.println("[" + ans[0] + ", " + ans[1] + "]");
		ans = new Solution().searchRange(new int[] {5,7,7,8,8,10}, 6);
		System.out.println("[" + ans[0] + ", " + ans[1] + "]");
		ans = new Solution().searchRange(new int[] {}, 0);
		System.out.println("[" + ans[0] + ", " + ans[1] + "]");
		ans = new Solution().searchRange(new int[] {2, 2}, 2);
		System.out.println("[" + ans[0] + ", " + ans[1] + "]");
	}
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
        	return new int[] {-1, -1};
        }
        
        int[] ret = new int[2];
        
        // find first
        ret[0] = -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
        	int mid = (lo + hi) / 2;
        	if(nums[mid] == target) {
        		ret[0] = mid;
        		hi = mid - 1;
        	}
        	
        	if(nums[mid] < target) {
        		lo = mid + 1;
        	} else {
        		hi = mid - 1;
        	}
        }
        
        // find last
        ret[1] = -1;
        lo = 0;
        hi = nums.length - 1;
        while(lo <= hi) {
        	int mid = (lo + hi) / 2;
        	if(nums[mid] == target) {
        		ret[1] = mid;
        		lo = mid + 1;
        	}
        	
        	if(nums[mid] <= target) {
        		lo = mid + 1;
        	} else {
        		hi = mid - 1;
        	}
        }
        
        return ret;
    }
}


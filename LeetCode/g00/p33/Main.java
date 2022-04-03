/**
 * 
 */
package g00.p33;

/**
 * LeetCode 33. Search in Rotated Sorted Array
 * Medium
 * 2 ms, 38.9 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().search(int[] {4,5,6,7,0,1,2}, 0));
		System.out.println(new Solution().search(int[] {4,5,6,7,0,1,2}, 3));
		System.out.println(new Solution().search(int[] {1}, 0));
	}
}

class Solution {
    public int search(int[] nums, int target) {
        int p = nums[0];
        int a = -1;
        
        int lo = 0, hi = nums.length;
        while(true) {
        	if(hi - lo == 1) {
        		if(hi == nums.length) {
        			if(nums[lo] == target) {
        				return lo;
        			} else {
        				return -1;
        			}
        		} else {
        			if(nums[lo] > nums[hi]) {
        				a = hi;
        				break;
        			}
        		}
        	}
        	int m = (lo + hi) / 2;
        	if(nums[m] > p) {
        		lo = m;
        	} else if(nums[m] < p) {
        		hi = m;
        	}
        }
        
        if(target > p) {
        	lo = 0;
        	hi = a;
        	while(lo < hi) {
        		int m = (lo + hi) / 2;
        		if(nums[m] > target) {
        			hi = m;
        		} else if(nums[m] == target) {
        			return m;
        		} else if(nums[m] < target) {
        			lo = m;
        		}
        	}
        } else {
        	lo = a;
        	hi = nums.length;
        	while(lo < hi) {
        		int m = (lo + hi) / 2;
        		if(nums[m] > target) {
        			hi = m;
        		} else if(nums[m] == target) {
        			return m;
        		} else if(nums[m] < target) {
        			lo = m;
        		}
        	}
        }
        return -1;
    }
}


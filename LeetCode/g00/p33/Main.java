/**
 * 
 */
package g00.p33;

/**
 * LeetCode 33. Search in Rotated Sorted Array
 * Medium
 * 1 ms, 42.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().search(new int[] {4,5,6,7,0,1,2}, 0));
		System.out.println(new Solution().search(new int[] {4,5,6,7,0,1,2}, 3));
		System.out.println(new Solution().search(new int[] {4,5,6,7,0,1,2}, 2));
		System.out.println(new Solution().search(new int[] {1}, 0));
		System.out.println(new Solution().search(new int[] {1, 3}, 3));
		System.out.println(new Solution().search(new int[] {3, 1}, 3));
	}
}

class Solution {
    public int search(int[] nums, int target) {
        int p = nums[0];
        int a = -1;
        
        if(nums[0] < nums[nums.length - 1]) {
        	int lo = 0, hi = nums.length;
        	while(lo < hi) {
        		int m = (lo + hi) / 2;
        		if(nums[m] > target) {
        			hi = m;
        		} else if(nums[m] == target) {
        			return m;
        		} else if(nums[m] < target) {
        			if(m == hi - 1) {
        				break;
        			}
        			lo = m;
        		}
        	}
        	return -1;
        } else {
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
        }
        
        //System.out.println("a=" + a);
        
        if(target >= p) {
        	int lo = 0, hi = a;
        	while(lo < hi) {
        		int m = (lo + hi) / 2;
        		if(nums[m] > target) {
        			hi = m;
        		} else if(nums[m] == target) {
        			return m;
        		} else if(nums[m] < target) {
        			if(m == hi - 1) {
        				break;
        			}
        			lo = m;
        		}
        	}
        } else {
        	int lo = a, hi = nums.length;
        	while(lo < hi) {
        		int m = (lo + hi) / 2;
        		if(nums[m] > target) {
        			hi = m;
        		} else if(nums[m] == target) {
        			return m;
        		} else if(nums[m] < target) {
        			if(m == hi - 1) {
        				break;
        			}
        			lo = m;
        		}
        	}
        }
        return -1;
    }
}


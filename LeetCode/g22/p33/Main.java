/**
 * 
 */
package g22.p33;

import java.util.Arrays;

/**
 * LeetCode 2233. Maximum Product After K Increments
 * Medium
 * 31 ms, 51.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maximumProduct(new int[] {0, 4}, 5));
		System.out.println(new Solution().maximumProduct(new int[] {6, 3, 3, 2}, 2));
	}
}

class Solution {
    public int maximumProduct(int[] nums, int k) {
    	Arrays.sort(nums);
    	
        while(true) {
        	boolean flag = true;
        	int i;
        	for(i = 0; i < nums.length; ++i) {
        		if(nums[i] > nums[0]) {
        			int d = (nums[i] - nums[0]) * i;
        			if(d <= k) {
        				for(int j = 0; j < i; ++j) {
        					nums[j] = nums[i];
        				}
        				k -= d;
        				break;
        			} else {
        				flag = false;
        				break;
        			}
        		}
        	}
        	if(i == nums.length) {
        		break;
        	}
        	if(k == 0) {
        		break;
        	}
        	if(!flag) {
        		break;
        	}
        }
        
        if(k > 0) {
        	int i;
        	for(i = 0; i < nums.length; ++i) {
        		if(nums[i] > nums[0]) {
        			break;
        		}
        	}
        	int a = k / i;
        	if(a > 0) {
	        	for(int j = 0; j < i; ++j) {
	        		nums[j] += a;
	        	}
	        	k -= a * i;
        	}
        }
        
        if(k > 0) {
        	for(int i = 0; k > 0 && i < nums.length; ++i, --k) {
        		nums[i] += 1;
        	}
        }
        
        long m = 1L;
        for(int i = 0; i < nums.length; ++i) {
        	m *= nums[i];
        	if(m >= 1000000007) {
        		m %= 1000000007;
        	}
        }
        return (int)m;
    }
}

/**
 * 
 */
package g00.p41;

/**
 * LeetCode 41. First Missing Positive
 * Hard
 * 5 ms, 124.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().firstMissingPositive(new int[] {1,2,0}));
		System.out.println(new Solution().firstMissingPositive(new int[] {3,4,-1,1}));
		System.out.println(new Solution().firstMissingPositive(new int[] {7,8,9,11,12}));
		System.out.println(new Solution().firstMissingPositive(new int[] {1,2,6,3,5,4}));
	}
}

class Solution {
    public int firstMissingPositive(int[] nums) {
    	// 1. check 1
        boolean isOne = true;
        for(int i = 0; i < nums.length; ++i) {
        	if(nums[i] == 1) {
        		isOne = false;
        		break;
        	}
        }
        if(isOne) {
        	return 1;
        }
        // 2. mark 0 and negative number, mark bigger than size
        for(int i = 0; i < nums.length; ++i) {
        	if(nums[i] < 1 || nums[i] > nums.length) {
        		nums[i] = 1;
        	}
        }
        // 3. mark index
        for(int i = 0; i < nums.length; ++i) {
        	int index = Math.abs(nums[i]);
        	if(nums[index - 1] > 0) {
        		nums[index - 1] *= -1;
        	}
        }
        
        for(int i = 0; i < nums.length; ++i) {
        	if(nums[i] > 0) {
        		return i + 1;
        	}
        }
        
        return nums.length + 1;
    }
}


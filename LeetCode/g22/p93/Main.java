/**
 * 
 */
package g22.p93;

/**
 * LeetCode 2293. Min Max Game
 * Easy
 * 1 ms, 44.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minMaxGame(new int[] {01,3,5,2,4,8,2,2}));
	}
}

class Solution {
    public int minMaxGame(int[] nums) {
        if(nums.length == 1) {
        	return nums[0];
        }
        while(nums.length > 1) {
        	int[] newNums = new int[nums.length / 2];
        	for(int i = 0; i < nums.length / 2; ++i) {
        		if(i % 2 == 0) {
        			newNums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
        		} else {
        			newNums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
        		}
        	}
        	nums = newNums;
        }
        return nums[0];
    }
}

/**
 * 
 */
package g00.p26;

/**
 * LeetCode 26. Remove Duplicates from Sorted Array
 * Easy
 * 0 ms, 40.9 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().removeDuplicates(new int[] {1, 1, 2}));
		System.out.println(new Solution().removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}

}

class Solution {
	
    public int removeDuplicates(int[] nums) {
        if(nums.length > 0) {
        	int p = nums[0];
        	int c = 1;
        	int x = 1;
        	for(int i = 0; i < nums.length; ++i) {
        		if(nums[i] > p) {
        			c += 1;
        			nums[x] = nums[i];
        			x += 1;
        			p = nums[i];
        		}
        	}
        	return c;
        }
        return 0;
    }
}


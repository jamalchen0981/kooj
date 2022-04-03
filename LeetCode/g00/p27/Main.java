/**
 * 
 */
package g00.p27;

/**
 * LeetCode 27. Remove Element
 * Easy
 * 0 ms, 37.5 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().removeElement(new int[] {3,2,2,3}, 3));
		System.out.println(new Solution().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
	}

}

class Solution {
	
    public int removeElement(int[] nums, int val) {
        if(nums.length > 0) {
        	int x = 0;
        	for(int i = 0; i < nums.length; ++i) {
        		if(nums[i] != val) {
        			nums[x] = nums[i];
        			x += 1;
        		}
        	}
        	return x;
        }
        return 0;
    }
}


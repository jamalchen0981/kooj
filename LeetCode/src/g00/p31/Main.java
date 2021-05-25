/**
 * 
 */
package g00.p31;

/**
 * LeetCode 31. Next Permutation
 * Medium
 * 0 ms, 39.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		{
			int[] a1 = new int[] {5,1,1};
			new Solution().nextPermutation(a1);
			print(a1);
		}
		{
			int[] a1 = new int[] {3,2,1};
			new Solution().nextPermutation(a1);
			print(a1);
		}
		{
			int[] a1 = new int[] {1,1,5};
			new Solution().nextPermutation(a1);
			print(a1);
		}
		{
			int[] a1 = new int[] {1};
			new Solution().nextPermutation(a1);
			print(a1);
		}
		{
			int[] a1 = new int[] {1,2,3,4,5};
			new Solution().nextPermutation(a1);
			print(a1);
		}
		{
			int[] a1 = new int[] {1,3,5,4,2};
			new Solution().nextPermutation(a1);
			print(a1);
		}
	}
	
	private static void print(int[] a1) {
		for(int i = 0; i < a1.length; ++i) {
			System.out.print(a1[i] + " ");
		}
		System.out.println();
	}
}

class Solution {
	
    public void nextPermutation(int[] nums) {
        int x = -1;
        for(int i = nums.length - 1; i >= 1; --i) {
        	if(nums[i - 1] < nums[i]) {
        		x = i - 1;
        		break;
        	}
        }
        if(x >= 0) {
        	int t = nums[x];
        	int min = Integer.MAX_VALUE;
        	int y = -1;
        	for(int i = x + 1; i < nums.length; ++i) {
        		if(nums[i] > t && nums[i] <= min) {
        			min = nums[i];
        			y = i;
        		}
        	}
        	nums[x] = nums[y];
        	nums[y] = t;
        }
        for(int i = x + 1, j = nums.length - 1; i < j; ++i, --j) {
    		int t = nums[i];
    		nums[i] = nums[j];
    		nums[j] = t;
    	}
    }
}


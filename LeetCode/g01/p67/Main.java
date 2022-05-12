/**
 * 
 */
package g01.p67;

/**
 * LeetCode 167. Two Sum II - Input Array Is Sorted
 * Medium
 * 1 ms, 44.9 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().twoSum(new int[] {2,7,11,15}, 9)[0] + ", " + new Solution().twoSum(new int[] {2,7,11,15}, 9)[1]);
		System.out.println(new Solution().twoSum(new int[] {2,3,4}, 6)[0] + ", " + new Solution().twoSum(new int[] {2,3,4}, 6)[1]);
		System.out.println(new Solution().twoSum(new int[] {-1,0}, -1)[0] + ", " +  new Solution().twoSum(new int[] {-1,0}, -1)[1]);
	}
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int[] ret = new int[2];
    	int lt = 0, rt = numbers.length - 1;
    	while(lt <= rt) {
    		int sum = numbers[lt] + numbers[rt];
    		if(sum == target) {
    			return new int[] {lt + 1, rt + 1};
    		}
    		
    		if(sum > target) {
    			rt -= 1;
    		} else {
    			lt += 1;
    		}
    	}
        return ret;
    }
}

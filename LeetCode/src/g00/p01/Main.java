/**
 * 
 */
package g00.p01;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. Two Sum
 * Easy
 * 2ms, 39.5MB
 * 
 * @author jamal
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Solution obj = new Solution();
		int[] array = obj.twoSum(new int[] {3, 2, 4}, 6);
		System.out.println("[" + array[0] + ", " + array[1] + "]");
		
	}
}

class Solution {
	public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
    	
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; ++i) {
        	int sub = target - nums[i];
        	if(map.containsKey(sub) && map.get(sub) != i) {
        		return new int[] {i, map.get(sub)};
        	}
        }
        
        return null;
    }
}

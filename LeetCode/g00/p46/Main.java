/**
 * 
 */
package g00.p46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 46. Permutations
 * Medium
 * 1 ms, 42.4 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().permute(new int[] {1, 2, 3}));
	}
}

class Solution {
	public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; ++i) {
        	list.add(nums[i]);
        }
        
        permute(ans, list, 0);
        
        return ans;
    }
	
	private void permute(List<List<Integer>> ans, List<Integer> list, int k) {
		for(int i = k; i < list.size(); ++i) {
			Collections.swap(list, i, k);
			permute(ans, list, k + 1);
			Collections.swap(list, k, i);
		}
		if(k == list.size() - 1) {
			ans.add(new ArrayList<Integer>(list));
		}
	}
}


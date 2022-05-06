/**
 * 
 */
package g00.p47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 47. Permutations II
 * Medium
 * 118 ms, 43 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().permuteUnique(new int[] {1, 2, 3}));
		System.out.println(new Solution().permuteUnique(new int[] {1, 1, 2}));
	}
}

class Solution {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Map<String, Boolean> map = new HashMap<>();
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; ++i) {
        	list.add(nums[i]);
        }
        
        permute(map, ans, list, 0);
        
        return ans;
    }
	
	private void permute(Map<String, Boolean> map, List<List<Integer>> ans, List<Integer> list, int k) {
		for(int i = k; i < list.size(); ++i) {
			Collections.swap(list, i, k);
			permute(map, ans, list, k + 1);
			Collections.swap(list, k, i);
		}
		if(k == list.size() - 1) {
			String str = "";
			for(int i = 0; i < list.size(); ++i) {
				str += list.get(i);
			}
			if(!map.containsKey(str)) {
				map.put(str, true);
				ans.add(new ArrayList<Integer>(list));
			}
		}
	}
}


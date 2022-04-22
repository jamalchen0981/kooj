/**
 * 
 */
package g00.p39_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode 39. Combination Sum
 * Medium
 * 40 ms, 43.2 MB
 * Backtracking Version
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
			List<List<Integer>> list2D = new Solution().combinationSum(new int[] {2, 3, 6, 7}, 7);
			for(int i = 0; i < list2D.size(); ++i) {
				List<Integer> list = list2D.get(i);
				if(i > 0) {
					System.out.print(", ");
				}
				System.out.print("{");
				for(int j = 0; j < list.size(); ++j) {
					if(j > 0) {
						System.out.print(", ");
					}
					System.out.print(list.get(j));
				}
				System.out.print("}");
			}
			System.out.println();
		}
		{
			List<List<Integer>> list2D = new Solution().combinationSum(new int[] {2, 3, 5}, 8);
			for(int i = 0; i < list2D.size(); ++i) {
				List<Integer> list = list2D.get(i);
				if(i > 0) {
					System.out.print(", ");
				}
				System.out.print("{");
				for(int j = 0; j < list.size(); ++j) {
					if(j > 0) {
						System.out.print(", ");
					}
					System.out.print(list.get(j));
				}
				System.out.print("}");
			}
			System.out.println();
		}
		{
			List<List<Integer>> list2D = new Solution().combinationSum(new int[] {2}, 1);
			for(int i = 0; i < list2D.size(); ++i) {
				List<Integer> list = list2D.get(i);
				if(i > 0) {
					System.out.print(", ");
				}
				System.out.print("{");
				for(int j = 0; j < list.size(); ++j) {
					if(j > 0) {
						System.out.print(", ");
					}
					System.out.print(list.get(j));
				}
				System.out.print("}");
			}
			System.out.println();
		}
	}
}

class Solution {
	
	List<List<Integer>> list2D;
	Map<String, Integer> map;
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	list2D = new ArrayList<List<Integer>>();
    	map = new HashMap<String, Integer>();
        
    	List<Integer> list = new ArrayList<Integer>();
    	int sum = 0;
    	backtracking(candidates, target, sum, list);
    	
    	return list2D;
    }
    
    void backtracking(int[] candidates, int target, int sum, List<Integer> list) {
    	if(sum == target) {
    		list2D.add(list);
    		return;
    	}
    	for(int i = 0; i < candidates.length; ++i) {
    		if(sum + candidates[i] > target) {
    			break;
    		}
    		List<Integer> newList = new ArrayList<Integer>(list);
    		newList.add(candidates[i]);
    		List<Integer> sortedList = newList.stream().sorted().collect(Collectors.toList());
			String str = "";
			for(Integer a : sortedList) {
				str += a;
			}
			if(!map.containsKey(str)) {
				map.put(str, 1);
				backtracking(candidates, target, sum + candidates[i], sortedList);
			}
    	}
    }
}


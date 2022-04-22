/**
 * 
 */
package g00.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode 40. Combination Sum II
 * Medium
 * 37 ms, 43.4 MB
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
			List<List<Integer>> list2D = new Solution().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
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
			List<List<Integer>> list2D = new Solution().combinationSum2(new int[] {2,5,2,1,2}, 5);
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
			List<List<Integer>> list2D = new Solution().combinationSum2(new int[] {2}, 1);
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
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	list2D = new ArrayList<List<Integer>>();
    	map = new HashMap<String, Integer>();
        
    	List<Integer> list = new ArrayList<Integer>();
    	List<Boolean> flag = new ArrayList<Boolean>();
    	for(int i = 0; i < candidates.length; ++i) {
    		flag.add(false);
    	}
    	int sum = 0;
    	backtracking(candidates, target, sum, list, flag);
    	
    	return list2D;
    }
    
    void backtracking(int[] candidates, int target, int sum, List<Integer> list, List<Boolean> flag) {
    	if(sum == target) {
    		list2D.add(list);
    		return;
    	}
    	for(int i = 0; i < candidates.length; ++i) {
    		if(sum + candidates[i] > target) {
    			break;
    		}
    		if(flag.get(i).booleanValue() == false) {
	    		List<Integer> newList = new ArrayList<Integer>(list);
	    		newList.add(candidates[i]);
	    		List<Integer> sortedList = newList.stream().sorted().collect(Collectors.toList());
				String str = "";
				for(Integer a : sortedList) {
					str += a;
				}
				if(!map.containsKey(str)) {
					map.put(str, 1);
					List<Boolean> newFlag = new ArrayList<Boolean>();
					for(int j = 0; j < flag.size(); ++j) {
						if(i == j) {
							newFlag.add(true);
						} else {
							newFlag.add(flag.get(j));
						}
					}
					backtracking(candidates, target, sum + candidates[i], sortedList, newFlag);
				}
    		}
    	}
    }
}


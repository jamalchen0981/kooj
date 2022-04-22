/**
 * 
 */
package g00.p39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode 39. Combination Sum
 * Medium
 * 99 ms, 73.5 MB
 * Coin Change Version
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> list3D = new ArrayList<List<List<Integer>>>(target + 1);
        List<Map<String, Integer>> listMap = new ArrayList<Map<String, Integer>>(target + 1);
        for(int i = 0; i < target + 1; ++i) {
        	list3D.add(new ArrayList<List<Integer>>());
        	listMap.add(new HashMap<String, Integer>());
        }
        
        for(int i = 0; i < target + 1; ++i) {
        	for(int j = 0; j < candidates.length; ++j) {
        		if(i >= candidates[j] && i - candidates[j] == 0) {
        			List<Integer> next = new ArrayList<Integer>();
        			next.add(candidates[j]);
        			list3D.get(i).add(next);
        		}
        		if(i >= candidates[j] && list3D.get(i - candidates[j]).size() > 0) {
        			for(int k = 0; k < list3D.get(i - candidates[j]).size(); ++k) {
        				List<Integer> next = new ArrayList<Integer>(list3D.get(i - candidates[j]).get(k));
        				next.add(candidates[j]);
        				List<Integer> sortedList = next.stream().sorted().collect(Collectors.toList());
        				String str = "";
        				for(Integer a : sortedList) {
        					str += a;
        				}
        				if(!listMap.get(i).containsKey(str)) {
        					listMap.get(i).put(str, 1);
        					list3D.get(i).add(sortedList);
        				}
        			}
        		}
        	}
        }
        return list3D.get(target);
    }
}


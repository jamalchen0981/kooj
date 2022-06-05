/**
 * 
 */
package g22.p95;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode 2295. Replace Elements in an Array
 * Medium
 * 105 ms, 97.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ary = new Solution().arrayChange(new int[] {1,2,4,6}, 
				new int[][] {{1,3},{4,7},{6,1}});
		for(int i = 0; i < ary.length; ++i) {
			System.out.print(ary[i] + ",");
		}
		System.out.println();
	}
}

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
        	map.put(nums[i], i);
        }
        for(int i = 0; i < operations.length; ++i) {
        	int x = map.get(operations[i][0]);
        	map.remove(operations[i][0]);
        	map.put(operations[i][1], x);
        }
        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	Pair p = new Pair(entry.getValue(), entry.getKey());
        	list.add(p);
        }
        List<Pair> list2 = list.stream().sorted((a, b)-> {return a.index - b.index;}).collect(Collectors.toList());
        int[] ary = new int[nums.length];
        for(int i = 0; i < list2.size(); ++i) {
        	ary[i] = list2.get(i).value;
        }
        return ary;
    }
}

class Pair {
	int index;
	int value;
	public Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}
}

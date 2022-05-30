/**
 * 
 */
package g22.p79;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 2279. Maximum Bags With Full Capacity of Rocks
 * Medium
 * 601 ms, 106 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maximumBags(new int[] {2,3,4,5}, new int[] {1,2,4,4}, 2));
		System.out.println(new Solution().maximumBags(new int[] {10,2,2}, new int[] {2,2,0}, 100));
	}
}

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    	List<Integer> list = new ArrayList<>();
        int full = 0;
        for(int i = 0; i < capacity.length; ++i) {
        	if(capacity[i] == rocks[i]) {
        		full += 1;
        	} else if(rocks[i] < capacity[i]) {
        		list.add(capacity[i] - rocks[i]);
        	}
        }
        List<Integer> list2 = list.stream().sorted((a, b) -> {return a - b;}).collect(Collectors.toList());
        while(additionalRocks > 0 && list2.size() > 0) {
        	if(additionalRocks >= list2.get(0)) {
        		additionalRocks -= list2.get(0);
        		full += 1;
        		list2.remove(0);
        	} else {
        		break;
        	}
        }
        return full;
    }
}


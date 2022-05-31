/**
 * 
 */
package g22.p79;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 2279. Maximum Bags With Full Capacity of Rocks
 * Medium
 * 38 ms, 98.4 MB
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
        int[] ary = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ary);
        for(int i = 0; i < ary.length; ++i) {
        	if(additionalRocks >= ary[i]) {
        		additionalRocks -= ary[i];
        		full += 1;
        	} else {
        		break;
        	}
        }
        return full;
    }
}


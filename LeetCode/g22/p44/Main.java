/**
 * 
 */
package g22.p44;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2244. Minimum Rounds to Complete All Tasks
 * Medium
 * 45 ms, 59.8 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minimumRounds(new int[] {2,2,3,3,2,4,4,4,4,4}));
		System.out.println(new Solution().minimumRounds(new int[] {2,3,3}));

	}
}

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; ++i) {
        	if(map.containsKey(tasks[i])) {
        		map.put(tasks[i], map.get(tasks[i]) + 1);
        	} else {
        		map.put(tasks[i], 1);
        	}
        }
        int rounds = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
            	return -1;
            } else if(entry.getValue() % 3 == 0) {
            	rounds += entry.getValue() / 3;
            } else {
            	rounds += entry.getValue() / 3 + 1;
            }
        }
        return rounds;
    }
}


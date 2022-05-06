/**
 * 
 */
package g22.p60;

/**
 * LeetCode 2260. Minimum Consecutive Cards to Pick Up
 * Medium
 * 69ms, 52.1 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minimumCardPickup(new int[] {3,4,2,3,4,7}));
		System.out.println(new Solution().minimumCardPickup(new int[] {1,0,5,3}));
	}
}

class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] index = new int[1000002];
        for(int i = 0; i < 1000002; ++i) {
        	index[i] = -1;
        }
        int d = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; ++i) {
        	if(index[cards[i]] == -1) {
        		index[cards[i]] = i;
        	} else if(i - index[cards[i]] + 1 < d) {
        		d = i - index[cards[i]] + 1;
        		index[cards[i]] = i;
        	} else {
        		index[cards[i]] = i;
        	}
        }
        if(d == Integer.MAX_VALUE) {
        	return -1;
        }
        return d;
    }
}


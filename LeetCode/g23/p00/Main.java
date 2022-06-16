/**
 * 
 */
package g23.p00;

import java.util.Arrays;

/**
 * LeetCode 2300. Successful Pairs of Spells and Potions
 * Medium
 * 94 ms, 127.6 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ary = new Solution().successfulPairs(new int[] {5, 1, 3}, new int[] {1, 2, 3, 4, 5}, 7);
		for(int i = 0; i < ary.length; ++i) {
			System.out.print(ary[i] + ", ");
		}
		System.out.println();
	}
}

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
    	Arrays.sort(potions);
    	
        int[] ary = new int[spells.length];
        
        for(int i = 0; i < spells.length; ++i) {
        	ary[i] = 0;
        	
        	int l = 0, r = potions.length;
        	while(l < r) {
                int m = l + (r - l) / 2;
                
                if((long)spells[i]*potions[m]  >= success)
                    r = m;
                else
                    l = m + 1;
            }
            
        	ary[i] = potions.length - l;
        }
        
        return ary;
    }
}

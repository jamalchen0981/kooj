/**
 * 
 */
package g07.p44;

/**
 * LeetCode 744. Find Smallest Letter Greater Than Target
 * Easy
 * 1 ms, 47.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
		System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c'));
		System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'd'));
	}
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
    	int min_d = Integer.MAX_VALUE;
    	char min_c = 'a';
        for(int i = 0; i < letters.length; ++i) {
        	if(letters[i] > target) {
        		int d = letters[i] - target;
        		if(d < min_d) {
        			min_d = d;
        			min_c = letters[i];
        		}
        	} else if(letters[i] < target) {
        		int d = ('z' - letters[i]) + (letters[i] - 'a');
        		if(d < min_d) {
        			min_d = d;
        			min_c = letters[i];
        		}
        	} else if(letters[i] == target) {
        		int d = 26;
        		if(d < min_d) {
        			min_d = d;
        			min_c = letters[i];
        		}
        	}
        }
        return min_c;
    }
}

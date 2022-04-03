/**
 * 
 */
package g00.p11;

/**
 * LeetCode 11. Container With Most Water
 * Medium
 * 2 ms, 40.2 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maxArea(new int[] {1, 1}));
		System.out.println(new Solution().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
		System.out.println(new Solution().maxArea(new int[] {4,3,2,1,4}));
		System.out.println(new Solution().maxArea(new int[] {1,2,1}));
		System.out.println(new Solution().maxArea(new int[] {1,2}));
		System.out.println(new Solution().maxArea(new int[] {1,0,0,0,0,0,0,2,2}));
		System.out.println(new Solution().maxArea(new int[] {1,2,3,4,5,6,7,8,9,10}));
	}

}

class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}


/**
 * 
 */
package g00.p05;

/**
 * LeetCode 5. Longest Palindromic Substring
 * Medium
 * 7 ms, 39 MB
 * Manacher’s Algorithm
 * https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
 * 
 * @author jamal
 *
 */
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution2().longestPalindrome("babad"));
		System.out.println(new Solution2().longestPalindrome("cbbd"));
		System.out.println(new Solution2().longestPalindrome("a"));
		System.out.println(new Solution2().longestPalindrome("ac"));
	}

}

class Solution2 {
	public String longestPalindrome(String s) {
        int N = s.length(); 
        if (N == 0) 
            return "";
        if(N == 1) {
        	return s;
        }
        N = 2 * N + 1; // Position count 
        int[] L = new int[N + 1]; // LPS Length Array 
        L[0] = 0; 
        L[1] = 1; 
        int C = 1; // centerPosition 
        int R = 2; // centerRightPosition 
        int i = 0; // currentRightPosition 
        int iMirror; // currentLeftPosition 
        int maxLPSLength = 0; 
        int maxLPSCenterPosition = 0; 
        int start = -1; 
        int end = -1; 
        int diff = -1; 
  
        // Uncomment it to print LPS Length array 
        // printf("%d %d ", L[0], L[1]); 
        for (i = 2; i < N; i++)  
        { 
  
            // get currentLeftPosition iMirror  
            // for currentRightPosition i 
            iMirror = 2 * C - i; 
            L[i] = 0; 
            diff = R - i; 
  
            // If currentRightPosition i is within  
            // centerRightPosition R 
            if (diff > 0) 
                L[i] = Math.min(L[iMirror], diff); 
  
            // Attempt to expand palindrome centered at  
            // currentRightPosition i. Here for odd positions,  
            // we compare characters and if match then  
            // increment LPS Length by ONE. If even position,  
            // we just increment LPS by ONE without  
            // any character comparison 
            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&  
                               (((i + L[i] + 1) % 2 == 0) ||  
                         (s.charAt((i + L[i] + 1) / 2) ==  
                          s.charAt((i - L[i] - 1) / 2)))) 
            { 
                L[i]++; 
            } 
  
            if (L[i] > maxLPSLength) // Track maxLPSLength 
            { 
                maxLPSLength = L[i]; 
                maxLPSCenterPosition = i; 
            } 
  
            // If palindrome centered at currentRightPosition i 
            // expand beyond centerRightPosition R, 
            // adjust centerPosition C based on expanded palindrome. 
            if (i + L[i] > R)  
            { 
                C = i; 
                R = i + L[i]; 
            } 
  
            // Uncomment it to print LPS Length array 
            // printf("%d ", L[i]); 
        } 
  
        start = (maxLPSCenterPosition - maxLPSLength) / 2; 
        end = start + maxLPSLength - 1; 
        return s.substring(start, end + 1);
    }
}

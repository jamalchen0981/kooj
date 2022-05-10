/**
 * 
 */
package g02.p78;

/**
 * LeetCode 278. First Bad Version
 * Easy
 * 14 ms, 39 MB
 * 
 * @author jamal
 *
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1) {
        	return 1;
        }
        int lo = 1, hi = n, bad = 1;
        while(lo <= hi) {
        	int mid = lo + (hi - lo) / 2;
        	
        	if(isBadVersion(mid)) {
        		hi = mid - 1;
        		bad = mid;
        	} else {
        		lo = mid + 1;
        	}
        }
        return bad;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().firstBadVersion(5));
	}
}


class VersionControl {
	boolean isBadVersion(int version) {
		if(version == 4) {
			return true;
		}
		return false;
	}
}


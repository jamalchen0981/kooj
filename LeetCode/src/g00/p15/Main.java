/**
 * 
 */
package g00.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 15. 3Sum
 * Medium
 * 28 ms, 43.3 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().threeSum(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(new Solution().threeSum(new int[] {}));
		System.out.println(new Solution().threeSum(new int[] {0}));
		System.out.println(new Solution().threeSum(new int[] {1, 1, 1, -2}));
		System.out.println(new Solution().threeSum(new int[] {0, 0, 0}));
	}

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list2D = new ArrayList<>();
        if(nums.length > 0) {
        	Map<Integer, Integer> nMap = new HashMap<Integer, Integer>();
        	Map<Integer, Integer> pMap = new HashMap<Integer, Integer>();
        	List<Integer> nlist = new ArrayList<>();
        	List<Integer> plist = new ArrayList<>();
        	List<Integer> zlist = new ArrayList<>();
        	Arrays.sort(nums);
        	for(int i = 0; i < nums.length; ++i) {
        		if(nums[i] < 0) {
        			nlist.add(0, nums[i]);
        			nMap.put(nums[i], 1);
        		} else if(nums[i] == 0) {
        			zlist.add(0);
        		} else {
        			plist.add(nums[i]);
        			pMap.put(nums[i], 1);
        		}
        	}
        	int pre_i = 0;
        	// 2 negative, 1 positive
        	for(int i = 0; i < nlist.size(); ++i) {
        		if(nlist.get(i) != pre_i) {
        			pre_i = nlist.get(i);
        			int pre_j = 0;
	        		for(int j = i + 1; j < nlist.size(); ++j) {
	        			if(nlist.get(j) != pre_j) {
	        				pre_j = nlist.get(j);
		        			int x = -(nlist.get(i) + nlist.get(j));
		        			if(x >= 100000) {
		        				break;
		        			}
		        			if(pMap.get(x) != null) {
		        				list2D.add(Arrays.asList(new Integer[] {nlist.get(i), nlist.get(j), x}));
		        			}
	        			}
	        		}
        		}
        	}
        	pre_i = 0;
        	// 2 positive, 1 negative
        	for(int i = 0; i < plist.size(); ++i) {
        		if(plist.get(i) != pre_i) {
        			pre_i = plist.get(i);
        			int pre_j = 0;
	        		for(int j = i + 1; j < plist.size(); ++j) {
	        			if(plist.get(j) != pre_j) {
	        				pre_j = plist.get(j);
		        			int x = -(plist.get(i) + plist.get(j));
		        			if(x < -100000) {
		        				break;
		        			}
		        			if(nMap.get(x) != null) {
		        				list2D.add(Arrays.asList(new Integer[] {x, plist.get(i), plist.get(j)}));
		        			}
	        			}
	        		}
        		}
        	}
        	pre_i = 0;
        	// 1 zero, 1 positive, 1 negative, if necessary
        	if(zlist.size() > 0) {
        		for(int i = 0; i < nlist.size(); ++i) {
        			if(nlist.get(i) != pre_i) {
        				pre_i = nlist.get(i);
	        			int x = -nlist.get(i);
	        			if(pMap.get(x) != null) {
	        				list2D.add(Arrays.asList(new Integer[] {nlist.get(i), 0, x}));
	        			}
        			}
        		}
        	}
        	// 3 zero, if necessary
        	if(zlist.size() > 0) {
        		if(zlist.size() >= 3) {
        			list2D.add(Arrays.asList(new Integer[] {0, 0, 0}));
        		}
        	}
        }
        return list2D;
    }
}


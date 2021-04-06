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
 * 41 ms, 45.1 MB
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
//        	0 <= nums.length <= 3000
//        	-105 <= nums[i] <= 105
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
        	Map<Long, Integer> map = new HashMap<Long, Integer>();
        	// 2 negative, 1 positive
        	for(int i = 0; i < nlist.size(); ++i) {
        		for(int j = i + 1; j < nlist.size(); ++j) {
        			int x = -(nlist.get(i) + nlist.get(j));
        			if(x >= 100000) {
        				break;
        			}
        			if(pMap.get(x) != null) {
        				Long m = nlist.get(i) * 100000L +  nlist.get(j);
        				if(map.get(m) == null) {
        					list2D.add(Arrays.asList(new Integer[] {nlist.get(i), nlist.get(j), x}));
        					map.put(m, 1);
        				}
        			}
        		}
        	}
        	// 2 positive, 1 negative
        	for(int i = 0; i < plist.size(); ++i) {
        		for(int j = i + 1; j < plist.size(); ++j) {
        			int x = -(plist.get(i) + plist.get(j));
        			if(x < -100000) {
        				break;
        			}
        			if(nMap.get(x) != null) {
        				Long m = plist.get(i) * 100000L + plist.get(j);
        				if(map.get(m) == null) {
        					list2D.add(Arrays.asList(new Integer[] {x, plist.get(i), plist.get(j)}));
        					map.put(m, 1);
        				}
        			}
        		}
        	}
        	// 1 zero, 1 positive, 1 negative, if necessary
        	if(zlist.size() > 0) {
        		for(int i = 0; i < nlist.size(); ++i) {
        			int x = -nlist.get(i);
        			if(pMap.get(x) != null) {
        				Long m = (long)nlist.get(i);
        				if(map.get(m) == null) {
        					list2D.add(Arrays.asList(new Integer[] {nlist.get(i), 0, x}));
        					map.put(m, 1);
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


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
 * 158 ms, 47.8 MB
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
        	final int size = 200010;
        	int base = 100000;
        	int[] array = new int[size];
        	for(int i = 0; i < array.length; ++i) {
        		array[i] = 0;
        	}
        	List<Integer> nlist = new ArrayList<>();
        	List<Integer> plist = new ArrayList<>();
        	List<Integer> zlist = new ArrayList<>();
        	for(int i = 0; i < nums.length; ++i) {
        		array[ base + nums[i] ] += 1;
        	}
        	for(int i = base - 1; i >= 0; --i) {
    			for(int j = 0; j < array[i]; ++j) {
        			nlist.add(i - base);
    			}
        	}
        	for(int i = 0; i < array[base]; ++i) {
        		zlist.add(0);
        	}
        	for(int i = base + 1; i < size; ++i) {
        		for(int j = 0; j < array[i]; ++j) {
        			plist.add(i - base);
        		}
        	}
        	Map<String, Integer> map = new HashMap<String, Integer>();
        	// 2 negative, 1 positive
        	for(int i = 0; i < nlist.size(); ++i) {
        		for(int j = i + 1; j < nlist.size(); ++j) {
        			int x = -(nlist.get(i) + nlist.get(j)) + base;
        			if(x >= size) {
        				break;
        			}
        			if(array[x] > 0) {
        				String m = nlist.get(i) + "" +  nlist.get(j);
        				if(map.get(m) == null) {
        					list2D.add(Arrays.asList(new Integer[] {nlist.get(i), nlist.get(j), x - base}));
        					map.put(m, 1);
        				}
        			}
        		}
        	}
        	// 2 positive, 1 negative
        	for(int i = 0; i < plist.size(); ++i) {
        		for(int j = i + 1; j < plist.size(); ++j) {
        			int x = -(plist.get(i) + plist.get(j)) + base;
        			if(x < 0) {
        				break;
        			}
        			if(array[x] > 0) {
        				String m = plist.get(i) + "" + plist.get(j);
        				if(map.get(m) == null) {
        					list2D.add(Arrays.asList(new Integer[] {x - base, plist.get(i), plist.get(j)}));
        					map.put(m, 1);
        				}
        			}
        		}
        	}
        	// 1 zero, 1 positive, 1 negative, if necessary
        	if(zlist.size() > 0) {
        		for(int i = 0; i < nlist.size(); ++i) {
        			int x = -nlist.get(i) + base;
        			if(array[x] > 0) {
        				String m = nlist.get(i) + "" + 0;
        				if(map.get(m) == null) {
        					list2D.add(Arrays.asList(new Integer[] {nlist.get(i), 0, x - base}));
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


/**
 * 
 */
package g22.p76;

import java.util.TreeMap;

/**
 * LeetCode 2276. Count Integers in Intervals
 * Hard
 * 154 ms, 151.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountIntervals obj = new CountIntervals();
		obj.add(2, 3);
		obj.add(7, 10);
		obj.add(5, 8);
		System.out.println(obj.count());
	}
}

class CountIntervals {
	
	TreeMap<Integer, Integer> map;
	int count = 0;

    public CountIntervals() {
        map = new TreeMap<>();
    }
    
    public void add(int left, int right) {
        while(true) {
        	if(map.floorKey(right) == null || map.get(map.floorKey(right)) < left) {
        		break;
        	}
        	
        	int prevLeft = map.floorKey(right);
        	int prevRight = map.get(prevLeft);
        	
        	count -= prevRight - prevLeft + 1;
        	map.remove(prevLeft);
        	
        	left = Math.min(left, prevLeft);
        	right = Math.max(right, prevRight);
        }
        
        map.put(left, right);
        count += right - left + 1;
    }
    
    public int count() {
        return count;
    }
}


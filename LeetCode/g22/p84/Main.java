/**
 * 
 */
package g22.p84;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2284. Sender With Largest Word Count
 * Medium
 * 234 ms, 125.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().largestWordCount(new String[] {"Hello userTwooo","Hi userThree",
				"Wonderful day Alice","Nice day userThree"}, new String[] {"Alice","userTwo","userThree","Alice"}));
	}
}

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
    	int max = 0;
    	String ret = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < senders.length; ++i) {
        	String sender = senders[i];
        	if(map.get(sender) == null) {
        		String[] ary = messages[i].split("\\s+");
        		map.put(sender, ary.length);
        		if(ary.length > max) {
        			max = ary.length;
        			ret = sender;
        		} else if(ary.length == max) {
        			if(ret.compareTo(sender) < 0) {
        				ret = sender;
        			}
        		}
        	} else {
        		int prevLen = map.get(sender);
        		String[] ary = messages[i].split("\\s+");
        		map.put(sender, ary.length + prevLen);
        		if(ary.length + prevLen > max) {
        			max = ary.length + prevLen;
        			ret = sender;
        		} else if(ary.length + prevLen == max) {
        			if(ret.compareTo(sender) < 0) {
        				ret = sender;
        			}
        		}
        	}
        }
        return ret;
    }
}


/**
 * 
 */
package g22.p85;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 2285. Maximum Total Importance of Roads
 * Medium
 * 66 ms, 131.5 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().maximumImportance(5, new int[][] {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
		System.out.println(new Solution().maximumImportance(5, new int[][] {{0,3},{2,4},{1,3}}));
	}
}

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] ary = new int[n];
        Arrays.fill(ary, 0);
        for(int i = 0; i < roads.length; ++i) {
        	ary[roads[i][0]] += 1;
        	ary[roads[i][1]] += 1;
        }
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
        	Node node = new Node(i, ary[i]);
        	list.add(node);
        }
        List<Node> list2 = list.stream().sorted((a, b)->{ return a.value - b.value;}).collect(Collectors.toList());
        int[] ary2 = new int[n];
        int a = 1;
        for(int i = 0; i < list2.size(); ++i) {
        	ary2[list2.get(i).index] = a;
        	a += 1;
        }
        long ret = 0L;
        for(int i = 0; i < roads.length; ++i) {
        	ret += ary2[roads[i][0]];
        	ret += ary2[roads[i][1]];
        }
        return ret;
    }
}

class Node {
	int index;
	int value;
	public Node(int index, int value) {
		this.index = index;
		this.value = value;
	}
}


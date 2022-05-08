/**
 * 
 */
package g22.p65;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 2265. Count Nodes Equal to Average of Subtree
 * Medium
 * 40ms, 61.9 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(1);
		TreeNode t6 = new TreeNode(6);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = null;
		t2.right = t6;
		System.out.println(new Solution().averageOfSubtree(root));
	}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	
	int count;
	
    public int averageOfSubtree(TreeNode root) {
    	count = 0;
    	List<Integer> list = new ArrayList<>();
        cal(root, list);
        return count;
    }
    
    private int cal(TreeNode node, List<Integer> list) {
    	int lt_count = 0, rt_count = 0;
    	if(node.left != null) {
    		List<Integer> list2 = new ArrayList<>();
    		lt_count = cal(node.left, list2);
    		list.addAll(list2);
    	}
    	if(node.right != null) {
    		List<Integer> list3 = new ArrayList<>();
    		rt_count = cal(node.right, list3);
    		list.addAll(list3);
    	}
    	if(node.left != null || node.right != null) {
    		list.add(node.val);
    		int value = 0;
    		for(Integer i : list) {
    			value += i;
    		}
			if((value) / (lt_count + rt_count + 1) == node.val) {
				count += 1;
			}
    	} else {
    		list.add(node.val);
    		count += 1;
    	}
    	return lt_count + rt_count + 1;
    }
    
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


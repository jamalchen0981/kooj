/**
 * 
 */
package g13.p37;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 1337. The K Weakest Rows in a Matrix
 * Easy
 * 4 ms, 48.7 MB
 * 
 * @author jamal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ans = new Solution().kWeakestRows(new int[][] {{1,1,0,0,0},
			 {1,1,1,1,0},
			 {1,0,0,0,0},
			 {1,1,0,0,0},
			 {1,1,1,1,1}}, 3);
		for(int i = 0; i < ans.length; ++i) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
    	List<Solider> list = new ArrayList<>();
        for(int i = 0; i < mat.length; ++i) {
        	int count = 0;
        	for(int j = 0; j < mat[i].length; ++j) {
        		if(mat[i][j] == 1) {
        			count += 1;
        		} else {
        			break;
        		}
        	}
        	Solider solider = new Solider(count, i);
        	list.add(solider);
        }
        List<Solider> listNew = list.stream().sorted((e1, e2) -> {
        	if(e1.val == e2.val) {
        		return e1.index - e2.index;
        	}
        	return e1.val - e2.val;
        }).collect(Collectors.toList());
        int[] ans = new int[k];
        for(int i = 0; i < k; ++i) {
        	ans[i] = listNew.get(i).index;
        }
        return ans;
    }
}

class Solider {
	int val;
	int index;
	public Solider(int val, int index) {
		this.val = val;
		this.index = index;
	}
}
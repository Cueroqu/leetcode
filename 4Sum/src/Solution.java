import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	Arrays.sort(num);
    	int i, j, k, l, sum;
    	ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
    	for (i = 0; i < num.length - 3; ++i) {
    		if (i > 0 && num[i] == num[i-1]) continue;
    		for (j = i+1; j < num.length - 2; ++j) {
    			if (j >(i+1) && num[j] == num[j-1]) continue;
    			k = j+1; l = num.length - 1;
    			while (k < l) {
    				sum = num[i] + num[j] + num[k] + num[l];
    				if (sum == target) {
    					ArrayList<Integer> tmp = new ArrayList<Integer>();
    					tmp.add(num[i]); tmp.add(num[j]); tmp.add(num[k]); tmp.add(num[l]);
    					ret.add(tmp);
    					do {
    						++k;
    					} while (k < l && num[k] == num[k-1]);
    					do {
    						--l;
    					} while (k < l && num[l] == num[l+1]);
    				} else if (sum < target) {
    					do {
    						++k;
    					} while (k < l && num[k] == num[k-1]);
    				} else {
    					do {
    						--l;
    					} while (k < l && num[l] == num[l+1]);
    				}
    			}
    		}
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] a = {1, 0, -1, 0, -2, 2};
    	List<List<Integer>> ret = s.fourSum(a, 0);
    	for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < 4; ++j) {
    			System.out.format("%d ", ret.get(i).get(j));
    		}
    		System.out.println();
    	}
    }
}
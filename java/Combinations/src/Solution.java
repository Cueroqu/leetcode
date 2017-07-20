import java.util.*;

public class Solution {
	
	public void addCombination(List<List<Integer>> ret, Integer[] record, int index, int n, int k) {
		if (index == k) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (Integer i : record) {
				tmp.add(i);
			}
			ret.add(tmp);
			return ;
		}
		for (int i = record[index-1]+1; i <= n + index+1 - k; ++i) {
			record[index] = i;
			addCombination(ret, record, index+1, n, k);
		}
	}
	
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if (k < 1) return ret;
    	Integer[] record = new Integer[k];
    	for (int i = 1; i <= n+1-k; ++i) {
    		record[0] = i;
    		addCombination(ret, record, 1, n, k);
    	}
    	return ret;
    }
    
    public void print(List<List<Integer>> ret) {
    	for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < ret.get(i).size(); ++j) {
    			System.out.print(ret.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	s.print(s.combine(4, 2));
    }
}
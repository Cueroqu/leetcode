import java.util.*;
public class Solution {
	public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	ret.add(tmp);
    	Arrays.sort(S);
    	for (Integer i : S) {
    		int size = ret.size();
    		for (int j = 0; j < size; ++j) {
    			tmp = (ArrayList<Integer>)((ArrayList<Integer>)ret.get(j)).clone();
    			tmp.add(i);
    			ret.add(tmp);
    		}
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
    	int[] x = {1,2,3};
    	s.print(s.subsets(x));
    }
}
import java.util.*;
public class Solution {
	
	public void addToList(List<List<Integer>> ret, int index, int[] cnt, int[] candidates) {
		List<Integer> tmp = new ArrayList<Integer>();
		int i, j;
		for (i = 0; i < index + 1; ++i) {
			for (j = 0; j < cnt[i]; ++j)
				tmp.add(candidates[i]);
		}
		ret.add(tmp);
	}
	
	public void solve(List<List<Integer>> ret, int index, int[] cnt, int[] candidates, int target) {
		if (index >= candidates.length) return;
		for (int i = 0, t = target; i <= target / candidates[index]; ++i, t -= candidates[index]) {
			cnt[index] = i;
			if (t < candidates[index]) {
				if (t == 0) addToList(ret, index, cnt, candidates);
				return;
			}
			solve(ret, index+1, cnt, candidates, target - i*candidates[index]);
		}
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	int[] cnt = new int[candidates.length];
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	solve(ret, 0, cnt, candidates, target);
    	return ret;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] x = {2,3,6,7};
    	List<List<Integer>> ret = s.combinationSum(x, 7);
    	for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < ret.get(i).size(); ++j) {
    			System.out.print(ret.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    }
}
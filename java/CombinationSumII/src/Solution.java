import java.util.*;

public class Solution {
	
	public void addToList(List<List<Integer>> ret, int[] marked, int index, int[] num) {
		List<Integer> tmp = new ArrayList<Integer>();
		int i, j;
		for (i = 0; i < index; ++i) {
			for (j = 0; j < marked[i]; ++j)
				tmp.add(num[i]);
		}
		ret.add(tmp);
	}
	
	public void solve(List<List<Integer>> ret, int[] marked, int[] cnt, int index, int[] num, int length, int target) {
		if (index >= length) return;
		for (int i = 0, t = target; i <= cnt[index]; ++i, t -= num[index]) {
			marked[index] = i;
			if (t < num[index]) {
				if (t == 0) addToList(ret, marked, index+1, num);
				return;
			}
			solve(ret, marked, cnt, index+1, num, length, t);
		}
	}
	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int[] cnt = new int[num.length];
        int[] rnum = new int[num.length];
        int len = 0, scnt = 1, value = num[0];
        for (int i = 1; i < num.length; ++i) {
        	if (value != num[i]) {
        		cnt[len] = scnt;
        		rnum[len++] = value;
        		value = num[i];
        		scnt = 1;
        	} else ++scnt;
        }
        cnt[len] = scnt;
        rnum[len++] = value;
        int[] cur = new int[len];
        solve(ret, cur, cnt, 0, rnum, len, target);
        return ret;
    }
    
    public static void main(String[] args) {
    	int[] x = {10,1,2,7,6,5,1};
    	Solution s = new Solution();
    	List<List<Integer>> ret = s.combinationSum2(x, 8);
    	for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < ret.get(i).size(); ++j) {
    			System.out.print(ret.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    	
    }
}
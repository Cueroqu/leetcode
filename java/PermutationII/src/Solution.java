import java.util.*;

public class Solution {
	
	public void printIntArray(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public void printLists(List<List<Integer>> ret) {
		for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < ret.get(i).size(); ++j) {
    			System.out.print(ret.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if (num.length < 1) return ret;
    	else if (num.length < 2) {
    		List<Integer> tmp = new ArrayList<Integer>();
    		tmp.add(num[0]);
    		ret.add(tmp);
    		return ret;
    	}
    	Set<Integer> charset = new HashSet<Integer>();
    	for (int i = 0; i < num.length; ++i) {
    		if (charset.contains(num[i])) continue;
    		charset.add(num[i]);
    		int[] t = new int[num.length-1];
    		int[] a = Arrays.copyOfRange(num, 0, i);
    		int[] b = Arrays.copyOfRange(num, i+1, num.length);
    		System.arraycopy(a, 0, t, 0, a.length);
    		System.arraycopy(b, 0, t, a.length, b.length);
    		List<List<Integer>> tmp = this.permuteUnique(t);
    		for (List<Integer> list : tmp) {
    			List<Integer> tt = new ArrayList<Integer>();
    			tt.addAll(list);
    			tt.add(num[i]);
    			ret.add(tt);
    		}
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] x = {1,2,1};
    	List<List<Integer>> ret = s.permuteUnique(x);
    	s.printLists(ret);
    }
}
import java.util.*;
public class Solution {
    
    public List<Integer> count(int[] num) {
        int previous = num[0]-1;
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < num.length; ++i) {
            if (num[i] != previous) {
                previous = num[i];
                ret.add(i);
            }
        }
        ret.add(num.length);
        return ret;
    }
    
    public List<Integer> concat(List<Integer> l1, List<Integer> l2) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < l1.size(); ++i) ret.add(l1.get(i));
        for (int i = 0; i < l2.size(); ++i) ret.add(l2.get(i));
        return ret;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>(), listtmp = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        ret.add(tmp);
        if (num.length < 1) return ret;
        Arrays.sort(num);
        List<Integer> cnt = count(num);
        int i, j, k, len;
        for (i = 0; i < cnt.size() - 1; ++i) {
            listtmp.clear();
            for (j = cnt.get(i); j < cnt.get(i+1); ++j) {
                tmp = new ArrayList<Integer>();
                for (k = 0; k <= j-cnt.get(i); ++k) {
                	tmp.add(num[cnt.get(i)]);
                }
                listtmp.add(tmp);
            }
            len = ret.size();
            for (j = 0; j < len; ++j) {
                for (k = 0; k < listtmp.size(); ++k) {
                	ret.add(concat(ret.get(j), listtmp.get(k)));
                }
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
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	int[] x = {0};
    	Solution s = new Solution();
    	List<List<Integer>> ret = s.subsetsWithDup(x);
    	s.print(ret);
    }
    
}
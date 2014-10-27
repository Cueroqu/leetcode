import java.util.*;

public class Solution {
	
	public int Search(int[] num, int target) {
		int lo = 0, hi = num.length, mid;
		while (lo < hi) {
			mid = (lo+hi) / 2;
			if (num[mid] == target) {
				while (mid < num.length-1 && num[mid+1] == num[mid]) ++mid;
				return mid;
			}
			if (num[mid] < target) {
				lo = mid;
			} else {
				hi = mid;
			}
			if (lo == hi-1) return lo;
		}
		return hi;
	}
	
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int i, j, k, t;
        for (i = 0; i < num.length-1; ++i) {
        	if (i > 0 && num[i] == num[i-1]) continue;
        	k = Search(num, -num[i]-num[i+1]);
        	for (j = i+1; j < num.length && k > j; ++j) {
        		if (j > (i+1) && num[j] == num[j-1]) continue;
        		t = num[i]+num[j];
        		while (k > j && t+num[k] > 0) --k;
        		if (k <= j) break;
        		if (t+num[k] == 0) {
        			if (k <= j) break;
        			List<Integer> tmp = new ArrayList<Integer>();
        			tmp.add(num[i]); tmp.add(num[j]); tmp.add(num[k]);
        			ret.add(tmp);
        			t = num[k];
        			do {
        				--k;
        			} while (k > j && num[k] == t);
        		}
        	}
        }
        return ret;
    }
    
    public static void main(String[] args) {
    	int[] a = {-2,0,1,1,2};
    	Solution s = new Solution();
    	List<List<Integer>> ret = s.threeSum(a);
    	for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < 3; ++j) {
    			System.out.format("%d ", ret.get(i).get(j));
    		}
    		System.out.println();
    	}
    }
}
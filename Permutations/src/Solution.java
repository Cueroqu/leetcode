import java.util.*;

public class Solution {
	
	public void AddToList(List<List<Integer>> ret, int[] num) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num.length; ++i) {
			list.add(num[i]);
		}
		ret.add(list);
	}
	
	public void swap(int[] num, int[] p, int index) {
		int t = index+p[index];
		num[index] ^= num[t];
		num[t] ^= num[index];
		num[index] ^= num[t];
		p[index] += p[t];
		p[t] = p[index] - p[t];
		p[index] = p[index] - p[t];
	}
	
	public boolean HasNext(int[] num, int[] point2right) {
		int max = -1, t, index = 0, i;
		for (i = 0; i < num.length; ++i) {
			t = i + point2right[i];
			if (t >= 0 && t < num.length && num[t]<num[i] && max<num[i]) { 
				max = num[i];
				index = i;
			}
		}
		if (max == -1) return false;
		for (i = 0; i < num.length; ++i) {
			if (num[i] > num[index]) point2right[i] = -point2right[i];
		}
		swap(num, point2right, index);
		return true;
	}
	
    public List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if (num.length < 1) return ret;
    	int[] point2right = new int[num.length];
    	Arrays.fill(point2right, -1);
    	Arrays.sort(num);
    	AddToList(ret, num);
    	while (HasNext(num, point2right)) AddToList(ret, num);
    	return ret;
    }
    
    public List<List<Integer>> permute2(int[] num) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if (num.length == 0) return ret;
    	if (num.length == 1) {
    		List<Integer> tmp = new ArrayList<Integer>();
    		tmp.add(num[0]);
    		ret.add(tmp);
    		return ret;
    	}
    	
    	for (int i = 0; i < num.length; ++i) {
    		int[] a = Arrays.copyOfRange(num, 0, i);
    		int[] b = Arrays.copyOf(num, i+1);
    		int[] t = new int[num.length-1];
    		System.arraycopy(a, 0, t, 0, a.length);
    		System.arraycopy(b, 0, t, a.length, b.length);
    		List<List<Integer>> tmp = permute2(t);
    		for (List<Integer> list : tmp) {
    			List<Integer> tmplist = new ArrayList<Integer>();
    			tmplist.addAll(list);
    			tmplist.add(num[i]);
    			ret.add(tmplist);
    		}
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] x = {1,2,3};
    	List<List<Integer>> ret = s.permute(x);
    	for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < ret.get(i).size(); ++j) {
    			System.out.print(ret.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    }
}
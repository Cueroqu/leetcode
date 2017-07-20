import java.util.*;
public class Solution {
	
	public List<Integer> getHignests(int[] A) {
		List<Integer> Highest = new ArrayList<Integer>();
		Highest.add(0);
    	for (int i = 1, max = A[0]; i < A.length; ++i) {
    		if (A[i] > max) {
    			max = A[i];
    			Highest.clear();
    			Highest.add(i);
    		} else if (A[i] == max) {
    			Highest.add(i);
    		}
    	}
    	return Highest;
	}
	
	public List<Integer> getLeft(int end, int[] A) {
		List<Integer> ret = new ArrayList<Integer>();
		if (end < 1) return ret;
		int cur = A[0];
		ret.add(0);
		for (int i = 1; i < end; ++i) {
			if (A[i] > cur) {
				cur = A[i];
				ret.add(i);
			}
		}
		ret.add(end);
		return ret;
	}
	
	public List<Integer> getRight(int start, int[] A) {
		List<Integer> ret = new ArrayList<Integer>();
		if (start > A.length - 2) return ret;
		int cur = A[A.length-1];
		ret.add(A.length-1);
		for (int i = A.length-2; i > start; --i) {
			if (A[i] > cur) {
				cur = A[i];
				ret.add(i);
			}
		}
		ret.add(start);
		return ret;
	}
	
	public int sideContainer(List<Integer> pos, int[] A) {
		if (pos.size() < 2) return 0;
		int i = ((A[pos.get(0)] == 0) ? 1 : 0), j, sum = 0;
		int cur;
		for (; i < pos.size()-1; ++i) {
			cur = A[pos.get(i)];
			for (j = pos.get(i)+1; j < pos.get(i+1); ++j) {
				sum += (cur - A[j]);
			}
		}
		return sum;
	}
	
	public int rightContainer(List<Integer> pos, int[] A) {
		if (pos.size() < 2) return 0;
		int i, j, sum = 0;
		int cur;
		for (i = 0; i < pos.size()-1; ++i) {
			cur = A[pos.get(i)];
			for (j = pos.get(i)-1; j > pos.get(i+1); --j)
				sum+=(cur-A[j]);
		}
		return sum;
	}
	
	public int middle(List<Integer> Highest, int[] A) {
		if (Highest.size() < 2) return 0;
		int bound = A[Highest.get(0)], sum = 0;
		for (int i = Highest.get(0)+1; i < Highest.get(Highest.size()-1); ++i) {
			sum += (bound-A[i]);
		}
		return sum;
	}
	
    public int trap(int[] A) {
    	if (A.length < 1) return 0;
    	List<Integer> Highest = getHignests(A);
    	List<Integer> left = getLeft(Highest.get(0), A);
    	List<Integer> right = getRight(Highest.get(Highest.size()-1), A);
    	//System.out.println(sideContainer(left, A));
    	//System.out.println(sideContainer(right, A));
    	return sideContainer(left, A) + rightContainer(right, A) + middle(Highest, A);
    }
    
    public int trap2(int[] A) {
    	int left = 0, right = A.length - 1, block = 0, area = 0, curlevel = 0;
    	if (A.length < 3) return 0;
    	while (left <= right) {
    		if (Math.min(A[left], A[right]) > curlevel) {
    			area += (Math.min(A[left], A[right]) - curlevel) * (right - left + 1);
    			curlevel = Math.min(A[left], A[right]);
    		}
    		if (A[left] < A[right]) block += A[left++];
    		else block += A[right--];
    	}
    	return area - block;
    }
    
    public void print(List<Integer> A) {
    	for (int i = 0; i < A.size(); ++i) {
    		System.out.print(A.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] x = {4,2,3};
    	System.out.println(s.trap2(x));
    }
}
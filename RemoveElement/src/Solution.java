public class Solution {
	public int FindPrev(int[] A, int index, int target) {
		for (; index >= 0; --index) {
			if (A[index] != target) return index;
		}
		return index;
	}
	
	public void Swap(int[] A, int a, int b) {
		A[a] ^= A[b];
		A[b] ^= A[a];
		A[a] ^= A[b];
	}
	
    public int removeElement(int[] A, int elem) {
    	int tail = FindPrev(A, A.length-1, elem);
    	int i;
    	for (i = 0; i < A.length; ++i) {
    		if (A[i] == elem) {
    			if (i > tail) return i;
    			Swap(A, tail, i);
    			tail = FindPrev(A, tail-1, elem);
    		}
    	}
    	return i;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] x = {1,2,3,4,5,6,6,6,7};
    	System.out.println(s.removeElement(x, 1));
    }
}
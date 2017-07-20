public class Solution {
	
	public int lastPositiveIndex(int[] A, int origin) {
		for (int i = origin-1; i >= 0; --i) {
			if (A[i] > 0) return i;
		}
		return -1;
	}
	
	public void swap(int[] A, int a, int b) {
		A[a] ^= A[b];
		A[b] ^= A[a];
		A[a] ^= A[b];
	}
	
	public void print(int[] A, int length) {
		for (int i = 0; i < length; ++i)
			System.out.print(A[i] + " ");
		System.out.println();
	}
	
    public int firstMissingPositive(int[] A) {
    	int end = this.lastPositiveIndex(A, A.length), tmp, i, length = A.length, tmp2;
    	for (i = 0; i < A.length; ++i) {
    		if (A[i] < 1) {
    			if (i > end) {
    				length = i;
    				break;
    			} else {
        			swap(A, i, end);
        			end = this.lastPositiveIndex(A, end);
        		}
    		} 
    	}
    	if (length < 1) return 1;
    	for (i = 0; i < length; ++i) {
    		tmp = A[i];
    		while (tmp <= length && tmp != A[tmp-1]) {
    			tmp2 = A[tmp-1];
    			A[tmp-1] = tmp;
    			tmp = tmp2;
    		}
    	}
    	for (i = 0; i < length; ++i)
    		if (A[i] != i+1) return i+1;
    	return length+1;
    }
    
    public static void main(String[] args) {
    	int[] x = {2,1};
    	System.out.println((new Solution()).firstMissingPositive(x));
    }
}
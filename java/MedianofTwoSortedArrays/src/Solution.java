import java.util.Arrays;

public class Solution {
	
	public int findKthSmallestSortedArrays(int A[], int B[], int k) {
		int i = (int)((double)A.length/(A.length+B.length) * (k-1));
		int j = k-1-i;
		
		int Ai_1 = (i == 0) ? Integer.MIN_VALUE : A[i-1];
		int Bj_1 = (j == 0) ? Integer.MIN_VALUE : B[j-1];
		int Ai = (i == A.length) ? Integer.MAX_VALUE : A[i];
		int Bj = (j == B.length) ? Integer.MAX_VALUE : B[j];
		
		if (Ai_1 <= Bj && Bj <= Ai)
			return Bj;
		if (Bj_1 <= Ai && Ai <= Bj)
			return Ai;
		
		if (Bj <= Ai_1)
			return findKthSmallestSortedArrays(
					Arrays.copyOfRange(A, 0, i), 
					Arrays.copyOfRange(B, j+1, B.length), k-j-1);
		else
			return findKthSmallestSortedArrays(
					Arrays.copyOfRange(A, i+1, A.length),
					Arrays.copyOfRange(B, 0, j), k-i-1);
	}
	
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 == 1)
        	return findKthSmallestSortedArrays(A, B, ((A.length+B.length) >> 1) + 1);
        else
        	return (double)(findKthSmallestSortedArrays(A, B, (A.length+B.length) >> 1) + 
        			findKthSmallestSortedArrays(A, B, ((A.length+B.length) >> 1) + 1)) * 0.5;
    }
    
    public static void main(String args[]) {
    	int[] A = {1,2,3};
    	int[] B = {5,6};
    	Solution s = new Solution();
    	System.out.println(s.findMedianSortedArrays(A, B));
    }
}
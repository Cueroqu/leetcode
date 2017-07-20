public class Solution {
    public void sortColors(int[] A) {
    	int i = -1, j = -1, k = -1;
    	for (int m = 0; m < A.length; ++m) {
    		int v = A[m];
    		A[++k] = 2;
    		if (v == 1) A[++j] = 1;
    		else if (v == 0) {
    			A[++j] = 1;
    			A[++i] = 0;
    		}
    	}
    }
}
public class Solution {
    public int maxSubArray(int[] A) {
    	int max = Integer.MIN_VALUE, tmp = 0;
    	for (int i = 0; i < A.length; ++i) {
    		tmp += A[i];
    		max = Math.max(max, tmp);
    		if (tmp < 0) tmp = 0;
    	}
    	return max;
    }
}
public class Solution {
    public int singleNumber(int[] A) {
        int x0 = ~0, x1 = 0, x2 = 0;
        for (int i = 0; i < A.length; ++i) {
            int t = x2;
            x2 = (x1 & A[i]) | (x2 & ~A[i]);
            x1 = (x0 & A[i]) | (x1 & ~A[i]);
            x0 = (t & A[i]) | (x0 & ~A[i]);
        }
        return x1;
    }
}
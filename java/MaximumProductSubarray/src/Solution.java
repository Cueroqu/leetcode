public class Solution {
    public int maxProduct(int[] A) {
        if (A.length == 0) return 0;
        int curmax = A[0], curmin = A[0], ret = A[0];
        int premax = A[0], premin = A[0];
        for (int i = 1; i < A.length; ++i) {
            curmax = Math.max(Math.max(premax*A[i], premin*A[i]), A[i]);
            curmin = Math.min(Math.min(premax*A[i], premin*A[i]), A[i]);
            ret = Math.max(curmax, ret);
            premax = curmax;
            premin = curmin;
        }
        return ret;
    }
}
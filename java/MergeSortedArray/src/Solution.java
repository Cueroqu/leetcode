public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m+n-1, ia = m-1, ib = n-1;
        while (index >= 0 && ia >= 0 && ib >= 0) {
            if (A[ia] >= B[ib]) A[index--] = A[ia--];
            else A[index--] = B[ib--];
        }
        while (ib >= 0) A[index--] = B[ib--];
    }
}
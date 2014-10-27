public class Solution {
    public int removeDuplicates(int[] A) {
    	if (A.length == 0) return 0;
        int len = 1, i;
        for (i = 1; i < A.length; ++i) {
            if (A[i] != A[i-1]) A[len++] = A[i];
        }
        return len;
    }
    
    public static void main(String[] args) {
    	int[] x = {1,1,2};
    	Solution s = new Solution();
    	System.out.println(s.removeDuplicates(x));
    }
}
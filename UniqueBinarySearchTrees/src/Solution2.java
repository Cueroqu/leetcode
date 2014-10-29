public class Solution {
    int[][] cnt;
    
    public int numTrees(int start, int end) {
        if (start >= end) cnt[start][end] = 1;
        else {
            for (int i = start; i <= end; ++i) {
                if (cnt[start][i-1] == 0) cnt[start][i-1] = numTrees(start, i-1);
                if (cnt[i+1][end] == 0) cnt[i+1][end] = numTrees(i+1, end);
                cnt[start][end] += cnt[start][i-1] * cnt[i+1][end];
            }
        }
        return cnt[start][end];
    }
    
    public int numTrees(int n) {
        cnt = new int[n+2][n+2];
        return numTrees(1, n);
    }
}
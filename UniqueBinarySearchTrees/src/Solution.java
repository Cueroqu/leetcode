public class Solution {
    
    public int cntNumTrees(int n, int[] cnt) {
        if (cnt[n] > 0) return cnt[n];
        for (int i = 0; i < n; ++i) {
            cnt[i] = cntNumTrees(i, cnt);
            cnt[n-1-i] = cntNumTrees(n-1-i, cnt);
            cnt[n] += cnt[i]*cnt[n-1-i];
        }
        return cnt[n];
    }
    
    public int numTrees(int n) {
        int[] cnt = new int[n+1];
        cnt[0] = cnt[1] = 1;
        return cntNumTrees(n, cnt);
    }
}
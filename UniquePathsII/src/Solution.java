public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, i, j;
        int n = obstacleGrid[0].length;
        int[][] cnt = new int[m][n];
        cnt[0][0] = 1;
        for (i = 1; i < n; ++i) {
            cnt[0][i] = Math.min(1 - obstacleGrid[0][i], cnt[0][i-1]);
        }
        for (i = 1; i < m; ++i) {
            cnt[i][0] = Math.min(1 - obstacleGrid[i][0], cnt[i-1][0]);
        }
        for (i = 1; i < m; ++i) {
            for (j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) continue;
                cnt[i][j] = cnt[i-1][j] + cnt[i][j-1];
            }
        }
        return cnt[m-1][n-1];
    }
}
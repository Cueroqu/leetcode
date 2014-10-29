public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length < 1) return 0;
        int m = grid.length, n = grid[0].length, i, j;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (i = 1; i < n; ++i) sum[0][i] = sum[0][i-1] + grid[0][i];
        for (i = 1; i < m; ++i) sum[i][0] = sum[i-1][0] + grid[i][0];
        for (i = 1; i < m; ++i) {
            for (j = 1; j < n; ++j) {
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }
        return sum[m-1][n-1];
    }
}
public class Solution {
    public boolean inBound(int a, int b) {
        if (a < 0) return false;
        if (a >= b) return false;
        return true;
    }
    
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int right = 1, down = 1, cnt = 1, total = n*n, currow = 0, curcol = 0, i, j;
        boolean horizontal = true;
        while (cnt <= total) {
            if (horizontal) {
                for (i = curcol; inBound(i, n) && ret[currow][i] == 0; i += right) {
                    ret[currow][i] = cnt++;
                }
                curcol = i-right;
                horizontal = !horizontal;
                currow += down;
                right = -right;
            } else {
                for (i = currow; inBound(i, n) && ret[i][curcol] == 0; i += down) {
                    ret[i][curcol] = cnt++;
                }
                currow = i-down;
                horizontal = !horizontal;
                curcol += right;
                down = -down;
            }
        }
        return ret;
    }
}
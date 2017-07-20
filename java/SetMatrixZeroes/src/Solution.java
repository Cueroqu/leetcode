public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false, firstColumnHasZero = false;
        if (matrix.length < 1 || matrix[0].length < 1) return;
        int i, j;
        for (i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }
        for (i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (i = 1; i < matrix.length; ++i) {
            for (j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (i = 1; i < matrix.length; ++i) {
            for (j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstColumnHasZero) {
            for (i = 0; i < matrix.length; ++i) matrix[i][0] = 0;
        }
        if (firstRowHasZero) {
            for (i = 0; i < matrix[0].length; ++i) matrix[0][i] = 0;
        }
    }
}
public class Solution {
	
	public void swap(int[][] matrix, int m, int n) {
		int temp = matrix[m][n];
		matrix[m][n] = matrix[matrix.length - 1 - n][m];
		matrix[matrix.length-1-n][m] = matrix[matrix.length-1-m][matrix.length-1-n];
		matrix[matrix.length-1-m][matrix.length-1-n] = matrix[n][matrix.length-1-m];
		matrix[n][matrix.length-1-m] = temp;
	}
	
    public void rotate(int[][] matrix) {
    	int len = matrix.length;
    	for (int i = 0; i < len / 2; ++i) {
    		for (int j = i; j < len - i - 1; ++j) {
    			swap(matrix, i, j);
    		}
    	}
    	print(matrix);
    }
    
    public void print(int[][] matrix) {
    	for (int i = 0; i < matrix.length; ++i) {
    		for (int j = 0; j < matrix.length; ++j) {
    			System.out.print(matrix[i][j] +  " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	//int[][] x = {{1,2,3},{4,5,6},{7,8,9}};
    	int[][] x = {{1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};
    	Solution s = new Solution();
    	s.rotate(x);
    }
}
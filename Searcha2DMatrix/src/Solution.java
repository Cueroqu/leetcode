public class Solution {
	
	public boolean search(int[][] matrix, int left, int top, int right, int bottom, int target) {
		if (left < 0 || right >= matrix[0].length) return false;
		if (top < 0 || bottom >= matrix.length) return false;
		if (left > right) return false;
		if (top > bottom) return false;
		if ((right - left < 3) && (bottom - top) < 3) {
			for (int i = left; i <= right; ++i) {
				for (int j = top; j <= bottom; ++j) {
					if (matrix[j][i] == target) return true;
				}
			}
			return false;
		} 
		
		int midrow = (top + bottom) / 2, midcol = (left + right) / 2;
		if (matrix[midrow][midcol] == target) return true;
		else if (matrix[midrow][midcol] < target) {
			return search(matrix, midcol+1, top, right, midrow, target) || 
				   search(matrix, left, midrow+1, midcol, bottom, target) ||
				   search(matrix, midcol+1, midrow+1, right, bottom, target);
		}
		else {
			return search(matrix, midcol, top, right, midrow-1, target) ||
				   search(matrix, left, midrow, midcol-1, bottom, target) ||
				   search(matrix, left, top, midcol-1, midrow-1, target);
		}
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length < 1) return false;
    	if (matrix[0].length < 1) return false;
    	return search(matrix, 0, 0, matrix[0].length-1, matrix.length-1, target);
    }
    
    public static void main(String[] args) {
    	int[][] x ={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    	System.out.println((new Solution()).searchMatrix(x, 2));
    }
}
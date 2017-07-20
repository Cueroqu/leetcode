import java.util.*;
public class Solution {
	
	public boolean inBound(int a, int b) {
		if (a >= b) return false;
		if (a < 0) return false;
		return true;
	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> ret = new ArrayList<Integer>();
    	if (matrix.length < 1) return ret;
    	boolean[][] mark = new boolean[matrix.length][matrix[0].length];
    	int right = 1, down = 1, unmarked = matrix.length * matrix[0].length, rowIndex = 0, colIndex = 0, i;
    	boolean horizontal = true;
    	while (unmarked > 0) {
    		if (horizontal) {
    			for (i = colIndex;; i += right) {
    				--unmarked;
    				ret.add(matrix[rowIndex][i]);
    				mark[rowIndex][i] = true;
    				if (!inBound(i+right, matrix[0].length) || mark[rowIndex][i+right]) {
    					horizontal = !horizontal;
    					right = -right;
    					rowIndex += down;
    					colIndex = i;
    					break;
    				}
    			}
    		} else {
    			for (i = rowIndex;; i += down) {
    				ret.add(matrix[i][colIndex]);
    				mark[i][colIndex] = true;
    				--unmarked;
    				if (!inBound(i+down, matrix.length) || mark[i+down][colIndex]) {
    					horizontal = !horizontal;
    					down = -down;
    					colIndex += right;
    					rowIndex = i;
    					break;
    				}
    			}
    		}
    	}
    	return ret;
    }
    
    public void print(List<Integer> x) {
    	for (int i = 0; i < x.size(); ++i) {
    		System.out.print(x.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	int[][] x = {{1,2,3},{4,5,6},{7,8,9}};
    	Solution s = new Solution();
    	s.print(s.spiralOrder(x));
    	
    }
}
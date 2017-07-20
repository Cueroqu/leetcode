import java.util.*;
public class Solution {
	
	public int maxInRow(int[] record) {
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0, max = 0, t1, t2;
		while (index < record.length) {
			if (stack.empty() || stack.peek() <= record[index]) {
				stack.push(index++);
			} else {
				t1 = stack.pop();
				t2 = (stack.empty() ? index : index - stack.peek() - 1) * record[t1];
				if (t2 > max) max = t2;
			}
		}
		return max;
	}
	
    public int maximalRectangle(char[][] matrix) {
    	if (matrix.length < 1) return 0;
    	int[][] hrecord = new int[matrix.length][matrix[0].length];
    	int i, j;
    	for (i = 0; i < matrix[0].length; ++i) hrecord[0][i] = matrix[0][i] - '0';
    	for (i = 1; i < matrix.length; ++i) {
    		for (j = 0; j < matrix[0].length; ++j) {
    			hrecord[i][j] = (matrix[i][j] - '0') * (hrecord[i-1][j]+1);
    		}
    	}
    	int max = 0;
    	for (i = 0; i < matrix.length; ++i) {
    		max = Math.max(max, maxInRow(hrecord[i]));
    	}
    	return max;
    }
}
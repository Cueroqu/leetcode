import java.util.*;
public class Solution {
	
	public void mark(boolean[][] marked, int row, int col) {
		int i, size = marked.length;
		for (i = 0; i < size; ++i) {
			marked[i][col] = true;
			marked[row][i] = true;
		}
		int left = Math.min(row, col), right = Math.min(size-1-row, size-1-col);
		for (i = 1; i <= left; ++i) marked[row-i][col-i] = true;
		for (i = 1; i <= right; ++i) marked[row+i][col+i] = true;
		left = Math.min(size-1-row, col); right = Math.min(row, size-1-col);
		for (i = 1; i <= left; ++i) marked[row+i][col-i] = true;
		for (i = 1; i <= right; ++i) marked[row-i][col+i] = true;
	}
	
	public String[] Split(StringBuilder record, int size) {
		String[] ret = new String[size];
		for (int i = 0; i < size; ++i) {
			ret[i] = record.substring(i*size, (i+1)*size);
		}
		return ret;
	}
	
	public void solve(List<String[]> ret, StringBuilder record, int index, boolean[][] marked, int size) {
		if (index == size) {
			ret.add(Split(record, size));
			return;
		}
		int i, j, k;
		for (i = 0; i < size; ++i) {
			if (!marked[index][i]) {
				//System.out.format("index = %d, i = %d, %s\n", index, i, record.toString());
				//print(marked);
				boolean[][] restore = new boolean[size][size];
				for (j = 0; j < size; ++j)
					for (k = 0; k < size; ++k)
						restore[j][k] = marked[j][k];
				mark(marked, index, i);
				for (j = 0; j < i; ++j) record.append('.');
				record.append('Q');
				for (j = i+1; j < size; ++j) record.append('.');
				solve(ret, record, index+1, marked, size);
				record.delete(record.length()-size, record.length());
				for (j = 0; j < size; ++j)
					for (k = 0; k < size; ++k)
						marked[j][k] = restore[j][k];
			}
		}
	}
	
    public List<String[]> solveNQueens(int n) {
    	List<String[]> ret = new ArrayList<String[]>();
    	if (n == 0) return ret;
    	StringBuilder record = new StringBuilder();
    	boolean[][] marked = new boolean[n][n];
    	solve(ret, record, 0, marked, n);
    	return ret;
    }
    
    public void print(List<String[]> ret) {
    	
    	for (int i = 0; i < ret.size(); ++i) {
    		for (int j = 0; j < ret.get(i).length; ++j) {
    			System.out.println(ret.get(i)[j]);
    		}
    		System.out.println();
    	}
    }
    
    public void print(boolean[][] marked) {
    	for (int i = 0; i < marked.length; ++i) {
    		for (int j = 0; j < marked.length; ++j) {
    			if (marked[i][j]) System.out.print("1");
    			else System.out.print("0");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	s.print(s.solveNQueens(4));
    }
}
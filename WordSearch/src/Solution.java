public class Solution {
	
	int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public boolean inBound(char[][] board, int nrow, int ncol) {
		if (nrow < 0) return false;
		if (ncol < 0) return false;
		if (nrow >= board.length) return false;
		if (ncol >= board[0].length) return false;
		return true;
	}
	
	public boolean existAt(char[][] board, boolean[][] used, int row, int col, String word, int index) {
		if (index == word.length()) return true;
		int nrow, ncol;
		for (int i = 0; i < dir.length; ++i) {
			nrow = row + dir[i][0];
			ncol = col + dir[i][1];
			if (inBound(board, nrow, ncol) && board[nrow][ncol] == word.charAt(index) && !used[nrow][ncol]) {
				used[nrow][ncol] = true;
				if (existAt(board, used, nrow, ncol, word, index+1)) return true;
				used[nrow][ncol] = false;
			}
		}
		return false;
	}
	
    public boolean exist(char[][] board, String word) {
    	if (word.length() < 1) return true;
    	if (board.length < 1) return false;
    	boolean[][] used = new boolean[board.length][board[0].length];
    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[0].length; ++j) {
    			if (board[i][j] == word.charAt(0)) {
    				used[i][j] = true;
    				if (existAt(board, used, i, j, word, 1)) return true;
    				used[i][j] = false;
    			}
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	char[][] x = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    	System.out.println((new Solution()).exist(x, "SEE"));
    }
}
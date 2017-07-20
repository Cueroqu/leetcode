public class Solution {
	 public int getSquareIndex(int m, int n) {
		return m/3*3+n/3;
	}
	
    public boolean isValidSudoku(char[][] board) {
    	int i, j, k, t;
    	boolean[][][] maps = new boolean[3][9][9];
    	for (i = 0; i < 9; ++i) {
    		for (j = 0; j < 9; ++j) {
    			if (board[i][j] == '.') continue; 
    			k = board[i][j] - '1';
    			if (maps[0][j][k]) {
    				return false;
    			}
    			maps[0][j][k] = true;
    			if (maps[1][i][k]) {
    				return false;
    			}
    			maps[1][i][k] = true;
    			t = getSquareIndex(j, i);
    			if (maps[2][t][k]) {
    				return false;
    			}
    			maps[2][t][k] = true;
    		}
    	}
    	return true;
    }
    
    public char[][] convert(String[] ss) {
    	char[][] ret = new char[9][9];
    	for (int i = 0; i < 9; ++i) {
    		for (int j = 0; j < 9; ++j) {
    			ret[i][j] = ss[i].charAt(j);
    		}
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] ss = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
    	char[][] board = s.convert(ss);
    	System.out.println(s.isValidSudoku(board));
    }
}
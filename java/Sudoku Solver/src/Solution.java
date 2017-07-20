import java.io.IOException;
import java.util.*;

public class Solution {
	boolean[][][] records = new boolean[9][9][9];
    int[][] isSet = new int[9][9];
    int cnt = 81;
    
    public ArrayList<ArrayList<Integer>> updateRecords(int y, int x, int value) {
    	int i, j, t1, t2;
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
    	for (i = 0; i < 9; ++i) {
    		if (!records[y][i][value]) {
    			records[y][i][value] = true;
    			++isSet[y][i];
    			ArrayList<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(y); tmp.add(i); tmp.add(value);
    			ret.add(tmp);
    		}
    		if (!records[i][x][value]) {
    			records[i][x][value] = true;
    			++isSet[i][x];
    			ArrayList<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(i); tmp.add(x); tmp.add(value);
    			ret.add(tmp);
    		}
    	}
    	
    	t1 = y/3*3+3;
    	t2 = x/3*3+3;
    	for (i = y/3*3; i < t1; ++i) {
    		for (j = x/3*3; j < t2; ++j) {
    			if (!records[i][j][value]) {
    				records[i][j][value] = true;
    				++isSet[i][j];
    				ArrayList<Integer> tmp = new ArrayList<Integer>();
        			tmp.add(i); tmp.add(j); tmp.add(value);
        			ret.add(tmp);
    			}
    		}
    	}
    	return ret;
    }
    
    public void Initialize(char[][] board) {
    	int i, j;
    	for (i = 0; i < 9; ++i) {
    		for (j = 0; j < 9; ++j) {
    			if (board[i][j] != '.') {
    				updateRecords(i, j, board[i][j]-'1');
    				isSet[i][j] = 9;
    				--cnt;
    			} 
    		}
    	}
    }
	
    public void Simplify(char[][] board) {
    	int i, j, k, origin;
        Initialize(board);
        while (cnt > 0) {
        	origin = cnt;
        	for (i = 0; i < 9; ++i) {
        		for (j = 0; j < 9; ++j) {
        			if (isSet[i][j] > 8) continue;
        			if (isSet[i][j] == 8) {
        				for (k = 0; k < 9; ++k) {
        					if (!records[i][j][k]) {
        						board[i][j] = (char) (k + '1');
        						updateRecords(i, j, k);
        						break;
        					}
        				}
        				isSet[i][j] = 9;
        				--cnt;
        			}
        		}
        	}
            if (origin == cnt) return;
        }
    }
    
    public boolean further(char[][] board) {
//    	print(board);
//    	try {
//			System.in.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	boolean done = true;
    	int i = -1, j = 1, k;
    	outer:
    	for (i = 0; i < 9; ++i) {
    		for (j = 0; j < 9; ++j) {
    			if (board[i][j] == '.') {
    				done = false;
    				break outer;
    			}
    		}
    	}
    	if (done) return true;
    	for (k = 0; k < 9; ++k) {
    		if (!records[i][j][k]) {
    			records[i][j][k] = true;
    			board[i][j] = (char)(k+'1');
    			ArrayList<ArrayList<Integer>> tmp = updateRecords(i, j, k);
    			if (further(board)) return true;
    			board[i][j] = '.';
    			records[i][j][k] = false;
    			for (ArrayList<Integer> t : tmp) {
    				records[t.get(0)][t.get(1)][t.get(2)] = false;
    			}
    		}
    	}
    	//System.out.format("%d %d\n", i, j);
    	return false;
    }
    
    public void solveSudoku(char[][] board) {
        Simplify(board);
        if (cnt > 0) further(board);
        print(board);
    }
    
    public void print(char[][] board) {
    	for (int i = 0; i < 9; ++i) {
    		for (int j = 0; j < 9; ++j) {
    			System.out.format("%c ", board[i][j]);
    		}
    		System.out.println();
    	}
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
    	String[] ss = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	char[][] board = s.convert(ss);
    	s.solveSudoku(board);
    }
}
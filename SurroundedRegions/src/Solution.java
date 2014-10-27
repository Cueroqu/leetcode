import java.util.*;
public class Solution {
    public void solve(char[][] board) {
        if (board.length < 1) return;
        boolean[][] mark = new boolean[board.length][board[0].length];
        List<Integer> rown = new ArrayList<Integer>();
        List<Integer> coln = new ArrayList<Integer>();
        int[] dirr = new int[]{0, -1, 0, 1};
        int[] dirl = new int[]{-1, 0, 1, 0};
        int i, j, k, l, tr, tl;
        boolean shouldfill;
        for (i = 0; i < board.length; ++i) {
        	for (j = 0; j < board[0].length; ++j) {
        		if (!mark[i][j]) {
        			if (board[i][j] == 'X') {
        				mark[i][j] = true;
        			} else {
        				rown.clear();
        				coln.clear();
        				rown.add(i);
        				coln.add(j);
        				shouldfill = true;
        				for (k = 0; k < rown.size(); ++k) {
        					for(l = 0; l < dirr.length; ++l) {
        						tr = rown.get(k)+dirr[l];
        						tl = coln.get(k)+dirl[l];
        						if (tr < 0 || tr >= board.length || tl < 0 || tl >= board[0].length) {
        							shouldfill = false;
        							continue;
        						}
        						if (mark[tr][tl]) continue;
        						mark[tr][tl] = true;
        						if (board[tr][tl] == 'X') continue;
        						rown.add(tr);
        						coln.add(tl);
        					}
        				}
        				if (shouldfill) {
        					for (k = 0; k < rown.size(); ++k) {
        						board[rown.get(k)][coln.get(k)] = 'X';
        					}
        				}
        			}
        		}
        	}
        }
    }
    
    public void print(char[][] x) {
    	for (char[] cc : x) {
    		for (char c : cc) {
    			System.out.print(c + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	char[][] x = new char[][]{{'X','X','X','X'},{'X','0','0','X'},{'X','X','0','X'},{'X','0','X','X'}};
    	//char[][] x = new char[][]{{'0','0','0'},{'0','0','0'},{'0','0','0'}};
    	s.solve(x);
    	s.print(x);
    }
}
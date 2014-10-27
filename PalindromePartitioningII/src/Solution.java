import java.util.Arrays;

public class Solution {
	
	public void buildTable(String s, boolean[][] mark) {
		int i, j;
		mark[0][0] = true;
		for (i = 1; i < s.length(); ++i) {
			mark[i][i] = true;
			mark[i-1][i] = (s.charAt(i-1) == s.charAt(i));
		}
		for (i = 2; i < s.length(); ++i) {
			for (j = i; j < s.length(); ++j) {
				mark[j-i][j] = s.charAt(j-i)==s.charAt(j) && mark[j-i+1][j-1];
			}
		}
	}
	
    public int minCut(String s) {
        boolean[][] mark = new boolean[s.length()][s.length()];
        buildTable(s, mark);
        if (mark[0][s.length()-1]) return 0;
        int[][] cnt = new int[s.length()+1][s.length()+1];
        for (int[] a : cnt)
        	Arrays.fill(a, Integer.MAX_VALUE);
        int i, j;
        cnt[s.length()][s.length()] = 0;
        for (i = 0; i < cnt.length-1; ++i) {
        	cnt[i][i+1] = 0;
        	cnt[i][i] = 0;
        }
        for (i = s.length()-2; i >= 0; --i) {
        	if (mark[i][s.length()-1]) {
        		cnt[i][s.length()] = 0;
        		continue;
        	}
        	for (j = i; j < s.length(); ++j) {
        		if (mark[i][j] && cnt[j+1][s.length()] < Integer.MAX_VALUE) {
        			cnt[i][s.length()] = Math.min(cnt[i][s.length()], 1+cnt[j+1][s.length()]);
        		}
        	}
        }
        return cnt[0][s.length()];
    }
    
    public void print(int[][] cnt) {
    	for (int i = 0; i < cnt.length; ++i) {
    		System.out.format("cnt[%d][%d] = %d\n", i, cnt.length-1, cnt[i][cnt.length-1]);
    	}
//    	for (int i = 0; i < cnt.length; ++i) {
//    		for (int j = i; j < cnt[0].length; ++j) {
//    			System.out.format("cnt[%d][%d] = %d ", i, j, cnt[i][j]);
//    		}
//    		System.out.println();
//    	}
    }
    
    public static void main(String[] args) {
    	//System.out.println((new Solution()).minCut("aaab"));
    	System.out.println((new Solution()).minCut("cdd"));
    }
}
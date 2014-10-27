public class Solution {
    public int numDistinct(String S, String T) {
        int[][] total = new int[T.length()][S.length()];
        int i, j, k, sum;
        if (T.length() < 1 || S.length() < 1) return 0;
        if (S.charAt(0) == T.charAt(0)) total[0][0] = 1;
        for (i = 1; i < S.length(); ++i) {
        	total[0][i] = total[0][i-1];
        	if (S.charAt(i) == T.charAt(0)) {
        		++total[0][i];
        	} 
        }
        sum = 0;
        for (i = 1; i < T.length(); ++i) {
        	for (j = i; j < S.length(); ++j) {
        		total[i][j] = total[i][j-1];
                if (S.charAt(j) == T.charAt(i)) {
                    total[i][j] += total[i-1][j-1];
                }
            }
        }
        return total[T.length()-1][S.length()-1];
    }
    
    public void print(int[][] m) {
    	for (int i = 0; i < m.length; ++i) {
    		for (int j = 0; j < m[0].length; ++j) {
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.numDistinct("rabbbit", "rabbit"));
    }
}
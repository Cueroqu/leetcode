public class Solution {
    public int minDistance(String word1, String word2) {
    	int[][] D = new int[word1.length()+1][word2.length()+1];
    	int i, j;
    	for (i = 0; i < D.length; ++i) D[i][0] = i;
    	for (i = 0; i < D[0].length; ++i) D[0][i] = i;
    	for (i = 1; i < D.length; ++i) {
    		for (j = 1; j < D[0].length; ++j) {
    			D[i][j] = D[i-1][j-1] + ((word1.charAt(i-1) == word2.charAt(j-1)) ? 0 : 1);
    			D[i][j] = Math.min(D[i][j], D[i-1][j]+1);
    			D[i][j] = Math.min(D[i][j], D[i][j-1]+1);
    		}
    	}
    	
    	return D[word1.length()][word2.length()];
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).minDistance("sea", "eat"));
    }
}
public class Solution {
	int[][] table = new int[200][200];
	
	public int[] add(int m, int n) {
		int[] ret = new int[200];
		for (int i = 2; i <= Math.max(m, n); ++i) {
			ret[i] = table[m][i] + table[n][i];
		}
		return ret;
	}
	
	public void buildtable(int num) {
		boolean flag = false;
		for (int k = 2; k < num; ++k) {
			flag = false;
			for (int i = 2; i < k; ++i) {
				if (k % i == 0) {
					table[k] = add(i, k/i);
					flag = true;
					break;
				}
			}
			if (!flag)
				table[k][k] = 1;
		}
	}
	
    public int uniquePaths(int m, int n) {
        buildtable(m+n);
        int[] ret = new int[200];
        for (int i = 2; i < m+n-1; ++i) {
        	for (int j = 2; j <= i; ++j) {
        		ret[j] += table[i][j];
        		if (i < m)
        			ret[j] -= table[i][j];
        		if (i < n)
        			ret[j] -= table[i][j];
        	}
        }
        int pos = 1;
        for (int i = 2; i <= m+n-2; ++i) {
        	pos *= Math.pow(i, ret[i]);
        }
        return pos;
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).uniquePaths(4, 4));
    }
}

public class Solution {
	int[] fact = new int[10];
	
	public String compute(int n, int[] value) {
		StringBuilder sb = new StringBuilder();
		boolean[] mark = new boolean[n+1];
		for (int i = n-1; i > 0; --i) {
			for (int j = 1, cnt = 0;; ++j) {
				if (!mark[j]) {
					if (cnt == value[i]) {
						mark[j] = true;
						sb.append(j);
						break;
					}
					++cnt;
				}
			}
		}
		for (int i = 1; i <= n; ++i) if (!mark[i]) sb.append(i);
		return sb.toString();
	}
	
    public String getPermutation(int n, int k) {
        int i;
        fact[0] = fact[1] = 1;
        for (i = 2; i < 10; ++i) {
        	fact[i] = fact[i-1] * i;
        }
        int[] value = new int[n+1];
        --k;
        for (i = n-1; i >= 1; --i) {
        	value[i] = k / fact[i];
        	k %= fact[i];
        }
        return compute(n, value);
    }
  
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).getPermutation(3,6));
    }
}

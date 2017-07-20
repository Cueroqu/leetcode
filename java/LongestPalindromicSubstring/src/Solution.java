public class Solution {
	public String addSharp(String s) {
		StringBuilder sb = new StringBuilder("#");
		for (int i = 0; i < s.length(); ++i) {
			sb.append(s.charAt(i));
			sb.append("#");
		}
		return sb.toString();
	}
	
    public String longestPalindrome(String s) {
    	if (s.length() < 2) return s;
    	String str = addSharp(s);
    	int R, i, j, max, mindex, center, mirror;
    	int[] record = new int[str.length()];
    	R = center = 0;
    	record[0] = max = mindex = 0;
    	for (i = 1; i < str.length(); ++i) {
    		mirror = (center << 1) - i;
    		if (R>i && mirror >= 0 && (i+record[mirror]<R)) record[i] = record[mirror];
    		else {
    			j = Math.max(R, i)+1;
    			while (j<str.length() && ((i<<1)-j) >= 0 && str.charAt(j) == str.charAt((i<<1)-j)) ++j;
    			R = j-1;
    			center = i;
    			record[i] = R-i;
    			if (record[i]>max) {
	    			max = record[i];
	    			mindex = i;
    			}
    		}
    	}
    	return s.substring((mindex-max)/2, (mindex+max)/2);
    }
    
    // with dp
    public String longestPalindrome2(String s) {
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	dp[0][0] = true;
    	int i, j, maxLen = 1, start = 0, end = 0;
    	for (i = 1; i < s.length(); ++i) {
    		dp[i][i] = true;
    		dp[i-1][i] = s.charAt(i-1) == s.charAt(i);
    		if (dp[i-1][i] && maxLen < 2) {
    			maxLen = 2;
    			start = i-1;
    			end = i;
    		}
    	}
    	for (i = 2; i < s.length(); ++i) {
    		for (j = 0; (j+i) < s.length(); ++j) {
    			dp[j][j+i] = dp[j+1][j+i-1] && (s.charAt(j) == s.charAt(j+i));
    			if (dp[j][j+i] && maxLen < i+1) {
    				maxLen = i+1;
    				start = j;
    				end = j+i;
    			}
    		}
    	}
    	return s.substring(start, end+1);
    }
    
    // dp2
    public String longestPalindrome3(String s) {
    	int k = 1, boundary, low = -1, high = -1, len = 0;
    	if (s.length() < 2) return s;
    	for (int i = 1; i < s.length(); ++i) {
    		
    		boundary = Math.min(i+1, s.length() - i);
    		k = 1;
    		while (k < boundary && s.charAt(i-k) == s.charAt(i+k)) ++k;
    		if (len < ((k<<1)-1)) {
    			low = i-k+1;
    			high = i+k-1;
    			len = high - low + 1;
    		}
    		
    		if (s.charAt(i-1) == s.charAt(i)) {
    			boundary = Math.min(i, s.length()-i);
    			k = 1;
    			while (k < boundary && s.charAt(i-1-k) == s.charAt(i+k)) ++k;
    			if (len < (k << 1)) {
    				low = i-k;
    				high = i+k-1;
    				len = high - low + 1;
    			}
    		}
    	}
    	return s.substring(low, high+1);
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).longestPalindrome("ccc"));
    }
}
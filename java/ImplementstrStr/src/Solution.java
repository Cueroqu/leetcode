public class Solution {
	int[] next;
	
	public void BuildNext(String needle) {
		next = new int[needle.length()];
		if (next.length < 1) return;
		next[0] = -1; 
		if (next.length > 1) next[1] = 0;
		int m = 0, t = -1;
		while (m < needle.length() - 1) {
			if (t < 0 || needle.charAt(t) == needle.charAt(m)) {
				++t; ++m;
				next[m] = ((needle.charAt(t) == needle.charAt(m)) ? next[t] : t);
			} else t = next[t];
		}
	}
	
    public String strStr(String haystack, String needle) {
    	int m = 0, j = 0;
    	if (needle.length() < 1) return haystack;
        BuildNext(needle);
        while (m < haystack.length()) {
        	if (j < 0 || needle.charAt(j) == haystack.charAt(m)) {
        		++j; ++m;
        		if (j == needle.length()) return haystack.substring(m-j);
        	} else {
        		j = next[j];
        	}
        }
        return null;
    }
    
    public static void main(String[] args) {
    	String t = "";
    	String p = "";
    	Solution s = new Solution();
    	System.out.println(s.strStr(t, p));
    }
}
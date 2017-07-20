public class Solution {
    public boolean isMatch(String s, String p) {
    	if (p.length() == 0)
    		return s.length() == 0;
    	if (p.length() == 1) {
    		if (p.charAt(0) == '.') return s.length() == 1;
    		else if (s.length() == 1) return p.charAt(0) == s.charAt(0);
    		return false;
    	}
    	if (p.charAt(1) == '*') {
    		int index = -1;
    		while ((index<s.length()) && ((index<0) || (p.charAt(0) == '.') || (s.charAt(index) == p.charAt(0)))) {
    			if (isMatch(s.substring(index+1), p.substring(2))) return true;
    			++index;
    		}
    		return false;
    	} else {
    		if (s.length() < 1) return false;
    		if (p.charAt(0) == '.') return isMatch(s.substring(1), p.substring(1));
    		else if (s.charAt(0) == p.charAt(0)) return isMatch(s.substring(1), p.substring(1));
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.isMatch("bb", ".bab"));
    }
}
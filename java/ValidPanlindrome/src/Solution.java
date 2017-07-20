public class Solution {
	
	
	
    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        for (;;) {
        	while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start))) start++;
        	while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) --end;
        	if (start >= end) break;
        	if (s.charAt(start) != s.charAt(end)) return false;
        	++start;
        	--end;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).isPalindrome("race a car"));
    }
}
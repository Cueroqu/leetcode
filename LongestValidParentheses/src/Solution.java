public class Solution {
    public int longestValidParentheses(String s) {
    	if (s.length() < 1) return 0;
    	int[] match = new int[s.length()];
    	int[] stack = new int[s.length()];
    	int i, index = 0;
    	for (i = 0; i < s.length(); ++i) {
    		if (s.charAt(i) == '(') {
    			stack[index++] = i;
    			match[i] = -1;
    		} else {
    			if (index > 0) {
    				match[i] = stack[--index];
    				match[stack[index]] = i;
    			} else {
    				match[i] = -1;
    			}
    		}
    	}
    	int ret = 0, tmp = 0;
    	for (i = 0; i < s.length(); ++i) {
    		if (match[i] < 0) {
    			if (tmp > ret) ret = tmp;
    			tmp = 0;
    		} else {
    			tmp += match[i] - i + 1;
    			i = match[i];
    		}
    	}
    	return Math.max(tmp, ret);
    }
    
    public static void main(String[] args) {
    	String ss = "(()())";
    	Solution s = new Solution();
    	System.out.println(s.longestValidParentheses(ss));
    }
}
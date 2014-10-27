import java.util.*;
public class Solution {
    public boolean isValid(String s) {
    	StringBuilder sb = new StringBuilder();
    	HashMap<Character, Character> map = new HashMap<Character, Character>();
    	map.put(')', '('); map.put('}', '{'); map.put(']', '[');
    	for (int i = 0; i < s.length(); ++i) {
    		switch (s.charAt(i)) {
    		case '(':
    		case '{':
    		case '[':
    			sb.append(s.charAt(i));
    			break;
    		case ')':
    		case '}':
    		case ']':
    			if (sb.length() < 1) return false;
    			if (map.get(s.charAt(i)) == sb.charAt(sb.length() - 1))
    				sb.deleteCharAt(sb.length()-1);
    			break;
    		default:
    			return false;
    		}
    	}
    	return sb.length() == 0;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.isValid("{}"));
    }
}
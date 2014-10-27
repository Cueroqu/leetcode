import java.util.*;

public class Solution {
	public String[] maps = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
    	ArrayList<String> ret = new ArrayList<String>();
    	if (digits.length() < 1) {
    		ret.add("");
    		return ret;
    	}
        StringBuilder sb = new StringBuilder();
        int i, num = 0;
        int[] index = new int[digits.length()];
        for (i = 0; i < index.length; ++i) index[i] = 0;
        for (i = 0;;) {
        	if (i < digits.length()) num = digits.charAt(i) - '0';
        	if (index[i] < maps[num].length()) {
        		if (i == digits.length() - 1) {
        			ret.add(sb.toString() + maps[num].charAt(index[i]));	
        			++index[i];
        		} else {
        			sb.append(maps[num].charAt(index[i]));
        			++i;
        		}
        	} else {
        		if (i == 0) break;
        		index[i] = 0;
        		--i;
        		++index[i];
        		sb.deleteCharAt(sb.length()-1);
        	}
        }
        return ret;
    }
    
    public static void print(List<String> ret) {
    	for (int i = 0; i < ret.size(); ++i) System.out.print(ret.get(i) + ",");
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	print(s.letterCombinations("203"));
    }
}
public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if (strs.length == 0) return "";
    	int len = strs[0].length(), j;
    	for (int i = 1; i < strs.length; ++i) {
    		if (len > strs[i].length()) len = strs[i].length();
    		for (j = 0; j < len; ++j) {
    			if (strs[i].charAt(j) != strs[i-1].charAt(j)) len = j;
    		}
    	}
    	return strs[0].substring(0, len);
    }
    
    public String longestCommonPrefix2(String[] strs) {
    	if (strs.length == 0) return "";
    	int i, j;
    	for (i = 0; i < strs[0].length(); ++i) {
    		for (j = 1; j < strs.length; ++j) {
    			if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
    				return strs[0].substring(0, i);
    		}
    	}
    	return strs[0];
    }
}
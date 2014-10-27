public class Solution {
    public String convert(String s, int nRows) {
    	if (nRows < 2) return s;
    	int i, j, jmp, jmp2, cnt;
    	StringBuilder ret = new StringBuilder();
    	jmp = (nRows << 1) - 2;
    	for (i = 0; i < s.length(); i += jmp) {
    		ret.append(s.charAt(i));
    	}
    	for (i = 1; i < nRows - 1; ++i) {
    		jmp = ((nRows - i) << 1) - 2;
    		jmp2 = ((i+1) << 1) - 2;
    		for (j = i, cnt = 0; j < s.length(); ++cnt) {
    			ret.append(s.charAt(j));
    			if (cnt % 2 == 0) j += jmp;
    			else j += jmp2;
    		}
    	}
    	jmp = (nRows << 1) - 2;
    	for (i = nRows - 1; i < s.length(); i += jmp) {
    		ret.append(s.charAt(i));
    	}
    	return ret.toString();
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String ss = "PAYPALISHIRING";
    	System.out.println(s.convert(ss, 4));
    	
    }
}
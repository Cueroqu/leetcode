public class Solution {
    public String countAndSay(int n) {
    	String tmp = "1";
    	StringBuilder s = new StringBuilder();
    	int t = n, index, cnt, value = -1;
    	while (--t > 0) {
    		cnt = 1;
    		value = tmp.charAt(0)-'0';
    		for (index = 1; index < tmp.length(); ++index) {
    			if (value != (tmp.charAt(index)-'0')) {
    				s.append(cnt);
    				s.append(value);
    				cnt = 1;
    				value = tmp.charAt(index)-'0';
    			} else ++cnt;
    		}
    		s.append(cnt);
    		s.append(value);
    		tmp = s.toString();
    		s.setLength(0);
    	}
    	return tmp;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.countAndSay(1));
    }
}
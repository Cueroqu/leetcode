public class Solution {
    public int atoi(String str) {
    	int index = 0, ret = 0, origin;
    	char c;
    	while (index < str.length() && (str.charAt(index) == ' ' || str.charAt(index) == '\t')) ++index;
    	if (index >= str.length()) return 0;
    	
    	int flag = 1;
    	c = str.charAt(index);
    	if (c == '-') {
    		flag = -1;
    		++index;
    	}
    	else if (c == '+') {
    		flag = 1;
    		++index;
    	}
    	
    	if (index >= str.length()) return 0;
    	c = str.charAt(index);
    	if (c >= '0' || c <= '9') {
    		while (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
    			if ((ret != 0) && (ret != 1) && (10 > Integer.MIN_VALUE / ret)) {    				
    				return ReturnInf(flag);
    			}
    			ret = (ret * 10) - (str.charAt(index++) - '0');
    			System.out.println("Ansew = " + ret);
    			if (ret > 0) return ReturnInf(flag);
    			if (index >= str.length()) break;
    		}
    		if (flag == -1) return ret;
    		else {
    			if (ret == Integer.MIN_VALUE) return Integer.MAX_VALUE;
    			return -ret;
    		}
    	}
    	else return 0;
    }
    
    public int ReturnInf(int flag) {
    	if (flag > 0) return Integer.MAX_VALUE;
    	return Integer.MIN_VALUE;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(Integer.MIN_VALUE / -1);
    	System.out.println(s.atoi("      123"));
    }
}
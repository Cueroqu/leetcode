public class Solution {
    public int reverse(int x) {
    	int flag = (x >= 0) ? 1 : -1;
    	int ret = 0;
    	x = Math.abs(x);
    	while (x > 0) {
    		ret = (ret * 10) + (x % 10);
    		x /= 10;
    	}
    	return ret * flag;
    }
    
    public static void main(String [] args) {
    	Solution s = new Solution();
    	System.out.println(s.reverse(1000000003));
    }
}
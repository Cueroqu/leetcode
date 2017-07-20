public class Solution {
	
	public int getSign(int a) {
		if (a < 0) return -1;
		if (a > 0) return 1;
		return 0;
	}
	
	public long Abs(int a) {
		long ret = Math.abs(a);
		if (ret < 0) {
			ret = 2147483647;
			++ret;
		}
		return ret;
	}
	
    public int divide(int dividend, int divisor) {
    	if (divisor == 0) return Integer.MAX_VALUE * this.getSign(dividend);
    	if (dividend == 0) return 0;
    	int ansSign = this.getSign(dividend) * this.getSign(divisor);
    	long end = Abs(dividend), sor = Abs(divisor);
    	long rms = sor;
    	int ret = 0, rank = 1;
    	while (end >= sor) {
    		if (end >= rms) {
    			end -= rms;
    			ret += rank;
    			rms += sor;
    			++rank;
    		} else {
    			rank = 2;
    			rms = sor + sor;
    			++ret;
    			end -= sor;
    		}
    	}
    	return ret * ansSign;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.divide(-1010369383, -2147483648));
    }
}
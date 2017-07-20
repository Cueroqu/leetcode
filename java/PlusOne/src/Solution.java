public class Solution {
    public int[] plusOne(int[] digits) {
    	if (digits.length < 0) {
    		return new int[]{1};
    	}
    	int carry = 0;
    	digits[digits.length-1]++;
    	if (digits[digits.length-1] == 10) {
    		digits[digits.length-1] = 0;
    		carry = 1;
    		for (int i = digits.length-2; i >= 0; --i) {
    			digits[i] += carry;
    			if (digits[i] > 9) {
    				digits[i] %= 10;
    			} else return digits;
    		}
    		int[] ret = new int[digits.length+1];
    		ret[0] = 1;
    		for (int i = 0; i < digits.length; ++i) ret[i+1] = digits[i];
    		return ret;
    	} else return digits;
    }
}
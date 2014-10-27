import java.math.*;
public class Solution {
	/*
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int len, origin = x;
        for (len = 0; x > 0; ++len, x /= 10);
        x = origin;
        int hi = len - 1, lo = 0;
        int hib = 1, lob = 1;
        for (int i = 0; i < hi; ++i, hib *= 10); 
        while (hi > lo) {
        	if (((x / hib) % 10) != ((x / lob) % 10)) return false;
        	++lo; --hi;
        	hib /= 10; lob *= 10;
        }
        return true;
    }
    */
	
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		while (x > 0) {
			if (x/(int)(Math.pow(10, (int)Math.log10(x))) != x%10) return false;
			if ((int)Math.log10(x) > 0) {
				if (x/(int)(Math.pow(10, (int)Math.log10(x)-1)) % 10 == 0) {
					if (x/10%10 != 0) return false;
					x += 10;
					x += (int)(Math.pow(10, (int)Math.log10(x)-1));
				}
				x /= 10;
			}
			x -= x / (int)(Math.pow(10, (int)Math.log10(x))) * (int)(Math.pow(10, (int)Math.log10(x)));
		}
		return true;
	}
    public int test (double x) {
    	return (int)((x/(int)(Math.pow(10.0,(int)(Math.log10(x))))-1)*(int)(Math.pow(10,(int)(Math.log10(x))))); 
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.test(30));
    	System.out.println(s.isPalindrome(1112002111));
    }
}
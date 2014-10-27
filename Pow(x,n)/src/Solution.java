public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1.0/(x*pow(x, -1-n));
        double ans = x, right = 1;
        while (n > 1) {
        	if (n % 2 == 1) right *= ans;
        	ans *= ans;
        	n /= 2;
        	
        }
        return ans * right;
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).pow(5, 10));
    }
}
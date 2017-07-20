public class Solution {
	
	public int enumerate(int k, int x) {
		for (int i = k;; ++i)
			if (i*i > x || i*i <= 0) return i-1;
	}
	
    public int sqrt(int x) {
    	if (x < 2) return x;
    	int i;
    	for (i = 1; i <= x && (i<<1) > 0; i <<= 1) {
    		if (i*i>x || i*i <= 0) return enumerate(i>>1, x);
    	}
    	return enumerate(i,x);
    }
    
    public int sqrt2(int x) {
    	if (x == 0) return 0;
    	int ret, h = 0;
    	while ((long)(1<<h) * (long)(1<<h) <= x) ++h;
    	--h;
    	int b = h-1;
    	long t;
    	ret = 1<<h;
    	while (b >= 0) {
    		t = ret | (1<<b);
    		if (t*t <= x) ret |= (1<<b);
    		--b;
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).sqrt(2147395599));
    }
}
public class Solution {
	
	public void Swap(int[] num, int a, int b) {
		num[a] ^= num[b];
		num[b] ^= num[a];
		num[a] ^= num[b];
	}
	
	public void Reverse(int[] num, int head, int tail) {
		int len = (tail - head + 1) / 2;
		for (int i = head; i < head+len; ++i) {
			Swap(num, i, tail - i + head);
		}
	}
	
    public void nextPermutation(int[] num) {
    	if (num.length < 2) return;
    	int i, j;
    	for (i = num.length-2; i >= 0; --i) {
    		if (num[i] < num[i+1]) break;
    	}
    	if (i == - 1) {
    		Reverse(num, 0, num.length - 1);
    		return;
    	}
    	
    	for (j = num.length - 1; j > i; --j) {
    		if (num[j] > num[i]) break;
    	}
    	Swap(num, i, j);
    	Reverse(num, i+1, num.length-1);
    }
    
    public static void main(String[] args) {
    	int[] x = {1,3,2};
    	Solution s = new Solution();
    	
    	s.nextPermutation(x);
    	for (int i = 0; i < x.length; ++i) {
    		System.out.print(x[i] + " ");
    	}
    	System.out.println();
    }
}
public class Solution {
	
	public int binarySearch(int[] A, int head, int tail, double target) {
		if (head > tail) return 0;
		if (target < A[head]) return head;
		if (target > A[tail]) return tail+1;
		int mid = (head + tail) >> 1;
		if (target < A[mid]) {
			if (target > A[mid-1]) return mid;
			return binarySearch(A, head, mid-1, target);
		} else return binarySearch(A, mid+1, tail, target);
	}
	
    public int searchInsert(int[] A, int target) {
    	double t = target - 0.5;
    	return binarySearch(A, 0, A.length-1, t);
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] x = {1,3,5,6};
    	System.out.println(s.searchInsert(x, 0));
    }
}
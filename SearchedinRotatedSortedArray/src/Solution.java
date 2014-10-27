public class Solution {
	
	public int binarySearch(int[] A, int head, int tail, int target) {
		if (head > tail) return -1;
		if (target < A[head]) return -1;
		if (target > A[tail]) return -1;
		int mid = (head + tail) / 2;
		if (A[mid] == target) return mid;
		if (target < A[mid]) return binarySearch(A, head, mid-1, target);
		return binarySearch(A, mid+1, tail, target);
	}
	
	public int search(int[] A, int head, int tail, int target) {
		if (head > tail) return -1; 
		int mid = (head + tail) / 2;
    	if (A[head] <= A[mid]) {
    		if (A[mid] <= A[tail]) return binarySearch(A, head, tail, target);
    		else {
    			if (target >= A[head] && target <= A[mid])
    				return binarySearch(A, head, mid, target);
    			return search(A, mid+1, tail, target);
    		}
    	} else {
    		if (target >= A[mid] && target <= A[tail])
    			return binarySearch(A, mid, tail, target);
    		else return search(A, head, mid-1, target);
    	}
	}
	
    public int search(int[] A, int target) {
    	return search(A, 0, A.length-1, target);
    }
    
    public static void main(String args[]) {
    	int[] x = {6,7,0,1,2,3,5};
    	Solution s = new Solution();
    	System.out.println(s.search(x, 5));
    }
}
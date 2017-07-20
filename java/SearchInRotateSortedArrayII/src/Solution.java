public class Solution {
	
	public boolean binarySearch(int[] A, int head, int tail, int target) {
		int l = head, r = tail, mid;
		if (l > r) return false;
		while (l <= r) {
			mid = (l+r) >> 1;
			if (A[mid] == target) return true;
			if (A[mid] > target) r = mid-1;
			else if (A[mid] < target) l = mid+1;
		}
		return false;
	}
	
	public boolean search(int[] A, int head, int tail, int target) {
		if (head > tail) return false;
		int mid = (head + tail) >> 1;
		if (A[mid] == target) return true;
		if (A[head] < A[mid]) {
			if (A[mid] <= A[tail]) return binarySearch(A, head, tail, target);
			else {
				if (target >= A[head] && target < A[mid]) return binarySearch(A, head, mid-1, target);
				return search(A, mid+1, tail, target);
			}
		}
		if (A[head] > A[mid]) {
			if (target > A[mid] && target <= A[tail]) return binarySearch(A, mid+1, tail, target);
			return search(A, head, mid-1, target);
		}
		else {
			if (A[mid] != A[tail]) return search(A, mid+1, tail, target);
			if (search(A, head, mid-1, target)) return true;
			return search(A, mid+1, tail, target);
		}
	}
	
    public boolean search(int[] A, int target) {
    	return search(A, 0, A.length-1, target);
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).search(new int[]{2,3,4,6,0,1,2}, 5));
    }
}
public class Solution {
	
	int lb, hb;
	
	public int binarySearchMin(int[] A, int head, int tail, int target) {
		if (head > tail) return -1;
		if (target < A[head]) return -1;
		if (target > A[tail]) return -1;
		int mid = (head + tail) >> 1;
		if (A[mid] == target) {
			if (lb < mid) lb = mid;
			if (mid > 0 && A[mid-1] == target)
				return binarySearchMin(A, head, mid-1, target);
			else return mid;
		} else if (A[mid] > target) {
			if (hb > mid) hb = mid;
			return binarySearchMin(A, head, mid-1, target);
		} else {
			if (lb < mid) lb = mid;
			return binarySearchMin(A, mid+1, tail, target);
		}
	}
	
	public int binarySearchMax(int[] A, int head, int tail, int target) {
		if (head > tail) return -1;
		int mid = (head + tail) >> 1;
		if (A[mid] == target) {
			if (mid < tail && A[mid+1] == target)
				return binarySearchMax(A, mid+1, tail, target);
			else return mid;
		} else if (A[mid] < target) return binarySearchMax(A, mid+1, tail, target);
		return binarySearchMax(A, head, mid-1, target);
	}
	
	public int binarySearchLeft(int[] A, int head, int tail, int target) {
		int mid;
		while (head <= tail) {
			mid = (head + tail) >> 1;
			if (A[mid] >= target) tail = mid - 1;
			else head = mid + 1;
		}
		return head;
	}
	
	public int binarySearchRight(int[] A, int head, int tail, int target) {
		int mid;
		while (head <= tail) {
			mid = (head + tail) >> 1;
			if (A[mid] > target) tail = mid - 1;
			else head = mid + 1;
		}
		return head;
	}
	
    public int[] searchRange(int[] A, int target) {
    	lb = 0; hb = A.length-1;
    	int[] ret = new int[2];
    	ret[0] = binarySearchMin(A, 0, A.length - 1, target);
    	if (ret[0] == -1) ret[1] = -1;
    	else ret[1] = binarySearchMax(A, lb, hb, target);
    	return ret;
    }
    
    public int[] searchRange2(int[] A, int target) {
    	int[] ret = new int[2];
    	ret[0] = binarySearchLeft(A, 0, A.length - 1, target);
    	if (A[ret[0]] != target) ret[0] = ret[1] = -1;
    	else ret[1] = binarySearchRight(A, ret[0], A.length-1, target) - 1;
    	return ret;
    }
    
    public static void main(String[] args) {
    	int[] x = {5,6,7,7,10};
    	Solution s = new Solution();
    	int[] r = s.searchRange(x, 8);
    	//System.out.format("%d %d\n", r[0], r[1]);
    	System.out.println(s.binarySearchRight(x, 0, x.length-1, 7));
    }
}

public class Solution {
	public int findMin(int[] num) {
        int l = 0, r = num.length - 1, m;
        while (l < r) {
            m = (l+r) >> 1;
            if (num[r]<num[m]) l=m+1;
            else r = m;
        }
        return num[r];
    }
	public int findMin2(int[] num) {
        int l = 0, r = num.length - 1, m;
        while (l < r-1) {
            m = (l+r) >> 1;
            if (num[m-1]>num[m]) return num[m];
            if (num[m]<num[r]) r = m-1;
            else l = m+1;
        }
        return Math.min(num[l], num[r]);
    }
}

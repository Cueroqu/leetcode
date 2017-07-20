import java.util.*;
public class Solution {
    
    public void swap(int[] num, int start, int end) {
        num[start] ^= num[end];
        num[end] ^= num[start];
        num[start] ^= num[end];
    }
    
    public int tidy(int[] num) {
        int start = 0, end = num.length - 1;
        for (;;) {
            while (start < num.length && num[start] < 0) ++start;
            while (end >= 0 && num[end] >= 0) --end;
            if (start > end) break;
            swap(num, start, end);
            ++start; --end;
        }
        return end;
    }
    
    public void sort(int[] num, int start, int end) {
        if (start >= end) return;
        int max = 0, i, j, k, index;
        for (i = start; i <= end; ++i) {
            if (max < Math.abs(num[i])) max = Math.abs(num[i]);
        }
        int length = (int)Math.log10(max);
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        for (i = 0; i < 10; ++i) {
            List<Integer> list = new ArrayList<Integer>();
            array.add(list);
        }
        for (i = 0; i <= length; ++i) {
            for(List<Integer> list : array) list.clear();
            for (j = start; j <= end; ++j) {
                array.get((int)Math.abs(num[j] / Math.pow(10, i) % 10)).add(num[j]);
            }
            for (j = 0, index = start; j < 10; ++j) {
                for (k = 0; k < array.get(j).size(); ++k) {
                    num[index++] = array.get(j).get(k);
                }
            }
        }
        if (num[start] < 0) {
            for (i = start; i < (start+end+1)>>1; ++i) {
                swap(num, i, end-(i-start));
            }
            
        }
    }
    
    public int longestConsecutive(int[] num) {
        if (num.length < 2) return num.length;
        int end = tidy(num);
        sort(num, 0, end);
        sort(num, end+1, num.length - 1);
        int length = 1, expect = num[0] + 1, tmp = 1;
        for (int i = 1; i < num.length; ++i) {
            if (num[i] == expect) {
                ++expect;
                ++tmp;
                if (length < tmp) length = tmp;
            } else if (expect == num[i]+1) continue;
            else {
                expect = num[i]+1;
                tmp = 1;
            }
        }
        return length;
    }
    
    public void print(int[] num) {
    	for (int i : num) {
    		System.out.print(i + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
    }
}
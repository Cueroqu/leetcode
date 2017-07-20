import java.util.*;
public class Solution {
    public int candy(int[] ratings) {
    	int sum = 0, start, range = 0, drange = 0, i = 0;
        while (i < ratings.length) {
        	start = i;
        	while (start < ratings.length-1 && ratings[start+1]>ratings[start]) ++start;
        	range = start-i+1;
        	sum += range*(range+1)/2;
//        	System.out.format("inc: i = %d, start = %d, sum = %d\n", i, start, sum);
        	
        	i = ++start;
        	if (i >= ratings.length) break;
        	while (start < ratings.length-1 && ratings[start+1]<ratings[start]) ++start;
        	drange = start-i+1;
        	sum += drange*(drange+1)/2;
        	if (i > 0 && ratings[i] != ratings[i-1]) {
        		++drange;
        		if (drange > range) {
            		sum += drange-range;
            	}
        	}
        	--sum;
//        	System.out.format("dec: i = %d, start = %d, sum = %d\n", i, start, sum);
        	i = start;
        }
        return sum;
    }
    
    void print(int[] a) {
    	for (int i : a) {
    		System.out.format("%d ", i);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).candy(new int[]{2,2,1}));		// 4
    	System.out.println((new Solution()).candy(new int[]{1,2,2}));		// 4
    	System.out.println((new Solution()).candy(new int[]{2,1}));
    	System.out.println((new Solution()).candy(new int[]{1,2,4,4,3}));	//9
    	System.out.println((new Solution()).candy(new int[]{2,2}));	//2
    }
}

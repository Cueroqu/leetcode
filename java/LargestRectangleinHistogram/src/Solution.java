import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
    	Stack<Integer> index = new Stack<Integer>();
    	int max = 0, t, t2;
    	for (int i = 0; i < height.length; ++i) {
    		if (index.empty()) index.push(i);
    		else {
    			t = index.peek();
    			if (height[t] <= height[i]) {
    				//System.out.println("c: " + i);
    				index.push(i);
    			} else {
    				t = index.pop();
    				t2 = (i - 1 - (index.empty()?-1:index.peek())) * height[t];
    				//System.out.println("a: " + t2 + " " + t + " " + index.size() + " " + i);
    				if (t2 > max) {
    					max = t2;
    				}
    				while (!index.empty() && height[index.peek()] > height[i]) {
    					t = index.pop();
    					t2 = (i - 1 - (index.empty()?-1:index.peek())) * height[t];
    					//System.out.println("b: "+ t2 + " " + t + " " + index.size() + " " + i);
        				if (t2 > max) {
        					max = t2;
        				}
    				}
    				index.push(i);
    			}
    		}
    	}
    	while (!index.empty()) {
    		t = index.pop();
			t2 = (height.length - 1 - (index.empty()?-1:index.peek())) * height[t];
			//System.out.println(t2);
			if (t2 > max) {
				max = t2;
			}
    	}
    	return max;
    }
    public static void main(String[] args) {
    	System.out.println((new Solution()).largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
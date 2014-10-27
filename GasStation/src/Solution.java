import java.io.IOException;

public class Solution {
	
	int length;
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
    	int start = 0, total = 0, tank = 0;
    	for (int i = 0; i < gas.length; ++i) {
    		if ((tank = tank + gas[i] - cost[i]) < 0) {
    			start = i+1;
    			total += tank;
    			tank = 0;
    		}
    	}
    	return (total+tank < 0) ? -1 : start;
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).canCompleteCircuit(new int[]{2,3,1}, new int[]{3,1,2}));
    }
}
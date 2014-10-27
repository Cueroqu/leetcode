import java.util.*;

public class Solution {
	public class Pair {
		int value;
		int index;
	}
	
	Vector<Pair> Pairs = new Vector<Pair>();
	
	void Initiate(int[] numbers) {
		for (int i = 0; i < numbers.length; ++i) {
        	Pair t = new Pair();
        	t.index = i+1;
        	t.value = numbers[i];
        	Pairs.add(t);
        }
	}
	
	void Bucket(Vector<Pair> vec, int base) {
		Vector<Vector<Pair>> buckets = new Vector<Vector<Pair>>();
		int i, j;
		for (i = 0; i < 10; ++i) buckets.add(new Vector<Pair>());
		for (i = 0; i < vec.size(); ++i) {
			buckets.get((vec.get(i).value/base)%10).add(vec.get(i));
		}
		int k = 0;
		for (i = 0; i < 10; ++i) {
			for (j = 0; j < buckets.get(i).size(); ++j) {
				vec.set(k++, buckets.get(i).get(j));
			}
		}
	}
	
	void SubSort(Vector<Pair> vec, int max) {
		int cnt, base, i;
		for (cnt = 0; max > 0; ++cnt, max /= 10);
		for (i = 0, base = 1; i < cnt; ++i, base *= 10)
			Bucket(vec, base);
	}
	
	void Sort() {
		Vector<Pair> poss = new Vector<Pair>();
		Vector<Pair> negs = new Vector<Pair>();
		int min = 0, max = -1, i;
		for (i = 0; i < Pairs.size(); ++i) {
			if (Pairs.get(i).value >= 0) {
				poss.add(Pairs.get(i));
				if (Pairs.get(i).value > max)
					max = Pairs.get(i).value;
			}
			else {
				Pair t = new Pair();
				t.value = -Pairs.get(i).value;
				t.index = Pairs.get(i).index;
				negs.add(t);
				if (Pairs.get(i).value < min)
					min = Pairs.get(i).value;
			}
		}
		if (max > -1)
			SubSort(poss, max);
		if (min < 0) {
			min = -min;
			SubSort(negs, min);
		}
		int k = 0;
		for (i = 0; i < negs.size(); ++i) {
			Pair t = new Pair();
			t.value = -negs.get(i).value;
			t.index = negs.get(i).index;
			Pairs.set(k++, t);
		}
		for (i = 0; i < poss.size(); ++i) {
			Pairs.set(k++, poss.get(i));
		}
	}
	
    public int[] twoSum(int[] numbers, int target) {
    	Initiate(numbers);
    	Sort();
        int i = 0, j = numbers.length-1, tmp;
        int[] ret = new int[2];
        while (i < j) {
        	tmp = Pairs.get(i).value + Pairs.get(j).value;
        	if (tmp == target) {
        		if (Pairs.get(i).index > Pairs.get(j).index) {
        			ret[0] = Pairs.get(j).index;
        			ret[1] = Pairs.get(i).index;
        		} else {
        			ret[0] = Pairs.get(i).index;
        			ret[1] = Pairs.get(j).index;
        		}
        		return ret;
        	}
        	if (tmp < target) ++i;
        	if (Pairs.get(i).value + Pairs.get(j).value > target) --j;
        }
        return null;
    }
    
    public static void main(String[] args) {
    	int[] a = {1,2,3,4,5};
    	System.out.println(Arrays.copyOfRange(a, 0, 2)[2]);
    	Solution sol = new Solution();
    	int[] numbers = {-3,4,3,90};
    	int target = 0;
    	int[] ret = sol.twoSum(numbers, target);
    	System.out.format("%d %d", ret[0], ret[1]);
    }
}
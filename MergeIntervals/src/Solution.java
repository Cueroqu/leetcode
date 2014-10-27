import java.util.*;
public class Solution {
	class SortByStart implements Comparator<Interval> {
		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start) return 1;
			else if (o1.start < o2.start) return 0;
			if (o1.end > o2.end) return 1;
			else return 0;
		}
	}
	
	public List<Interval> Sort(List<Interval> intervals) {
		int max = intervals.get(0).start, i, j;
		for (i = 1; i < intervals.size(); ++i) max = Math.max(max, intervals.get(i).start);
		int length = (int)(Math.log10(max))+1, base;
		List<Interval>[] buckets = new List[10];
		for (i = 0; i < 10; ++i) buckets[i] = new ArrayList<Interval>();
		for (i = 0; i < length; ++i) {
			base = (int)Math.pow(10, i);
			for (j = 0; j < 10; ++j) buckets[j].clear();
			for (j = 0; j < intervals.size(); ++j) {
				buckets[(intervals.get(j).start/base)%10].add(intervals.get(j));
			}
			int index = 0;
			for (j = 0; j < 10; ++j)
				for (int k = 0; k < buckets[j].size(); ++k) {
					intervals.set(index++, buckets[j].get(k));
				}
		}
		return intervals;
	}
	
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> ret = new ArrayList<Interval>();
    	if (intervals.size() < 1) return ret;
    	intervals = Sort(intervals);
    	int curs, cure;
    	Interval cur = intervals.get(0);
    	curs = cur.start;
    	cure = cur.end;
    	for (int i = 1; i < intervals.size(); ++i) {
    		cur = intervals.get(i);
    		if (cure >= cur.start) {
    			cure = Math.max(cur.end, cure);
    		} else {
    			Interval ni = new Interval(curs, cure);
    			ret.add(ni);
    			curs = cur.start;
    			cure = cur.end;
    		}
    	}
    	ret.add(new Interval(curs, cure));
    	return ret;
    }
    
    public List<Interval> create(int[][] x) {
    	List<Interval> ret = new ArrayList<Interval>();
    	for (int i = 0; i < x.length; ++i) {
    		ret.add(new Interval(x[i][0],x[i][1]));
    	}
    	return ret;
    }
    
    public void print(List<Interval> list) {
    	for (int i = 0; i < list.size(); ++i) {
    		System.out.format("{%d, %d}, ", list.get(i).start, list.get(i).end);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	int[][] x = {{362,367},{314,315}};
    	Solution s = new Solution();
    	s.print(s.merge(s.create(x)));
    }
}
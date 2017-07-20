import java.util.*;

public class Solution {
	
	public int getValue(Interval a, int index) {
		if (index == 0) return a.start;
		else return a.end;
	}
	
	public int binarySearch(List<Interval> intervals, Interval newInterval, int index) {
		int l = 0, r = intervals.size()-1, mid, t;
		while (l <= r) {
			mid = (l+r)/2;
			t = getValue(intervals.get(mid), index) - getValue(newInterval, index);
			if (t > 0)
				r = mid-1;
			else if (t < 0)
				l = mid+1;
			else {
				for (int i = mid; i >= 0; --i)
					if (getValue(intervals.get(i), index) < getValue(newInterval, index))
						return i+1;
				return 0;
			}
		}
		if (r < 0) return 0;
		if (getValue(intervals.get(r), index) > getValue(newInterval, index)) return r;
		return r+1;
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals.size() < 1) {
        	ret.add(newInterval);
        	return ret;
        }
        int start = binarySearch(intervals, newInterval, 0), curs = newInterval.start, cure = newInterval.end, index = start;
        if (start > 0 && intervals.get(start-1).end >= newInterval.start) {
        	--start;
        	curs = intervals.get(start).start;
        	cure = Math.max(intervals.get(start).end, cure);
        }
        for (; index < intervals.size(); ++index) {
        	if (cure >= intervals.get(index).start)
        		cure = Math.max(intervals.get(index).end, cure);
        	else break;
        }
        Interval insert = new Interval(curs, cure);
        for (int i = index-1; i >= start; --i) {
        	intervals.remove(i);
        }
        intervals.add(Math.min(start, intervals.size()), insert);
        return intervals;
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
    	int[][] x = {{1,5}};
    	Solution s = new Solution();
    	s.print(s.insert(s.create(x), new Interval(0,0)));
    }
}
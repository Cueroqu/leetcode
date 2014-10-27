/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

import java.util.*;

public class Solution {
	
	class Line {
		double k;
		double b;
		int cnt;
		Set<Point> records;
		static final double eps = 0.000001;
		
		Line (Point a, Point b) {
			records = new HashSet<Point>();
			cnt = 0;
			if (a.x == b.x) {
				this.k = Double.MAX_VALUE;
				this.b = b.x;
				return;
			}
			this.k = (double)(a.y - b.y) / (double)(a.x - b.x);
			this.b = (double)a.y - k * (double)a.x;
		}
		
		boolean sameK(Line b) {
			if (Math.abs(this.k-b.k) < Line.eps) return true;
			return false;
		}
		boolean sameB(Line b) {
			if (Math.abs(this.b-b.b) < Line.eps) return true;
			return false;
		}
		boolean sameLine(Line b) {
			if (sameK(b) && sameB(b)) return true;
			return false;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(String.format("[k = %f, b = %f]\n", k, b));
			for (Point p : records) sb.append(String.format("[x = %d, y = %d]\n", p.x, p.y));
			sb.append(String.format("cur = %d\n", cnt));
			return sb.toString();
		}
	}
	
	class LineComparator implements Comparator<Line> {
		@Override
		public int compare(Line a, Line b) {
			if (a.sameK(b)) {
				if (a.sameB(b)) return 0;
				if (a.b < b.b) return -1;
				return 1;
			}
			if (a.k < b.k) return -1;
			return 1;
		}
	}
	
	class PointComparator implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			if (a.x < b.x) return -1;
			if (a.x > b.x) return 1;
			if (a.y < b.y) return -1;
			if (a.y > b.y) return 1;
			return 0;
		}
	}
	
//    public int maxPoints(Point[] points) {
//    	if (points.length < 3) return points.length;
//    	int i, j;
//    	
//    	Arrays.sort(points, new PointComparator());
//    	List<Point> depoints = new ArrayList<Point>();
//    	Map<Point, Integer> amount = new HashMap<Point, Integer>();
//    	Point curp = points[0];
//    	int cnt = 1;
//    	for (i = 1; i < points.length; ++i) {
//    		if (curp.x == points[i].x && curp.y == points[i].y){ 
//    			++cnt;
//    		} else {
//    			depoints.add(curp);
//    			amount.put(curp, cnt);
//    			cnt = 1;
//    			curp = points[i];
//    		}
//    	}
//    	depoints.add(curp);
//    	amount.put(curp, cnt);
//    	if (depoints.size() == 1) return amount.get(depoints.get(0));
//    	
//    	List<Line> lines = new ArrayList<Line>();
//    	for (i = 0; i < depoints.size() - 1; ++i) {
//    		for (j = i+1; j < depoints.size(); ++j) {
//    			Line tmp = new Line(depoints.get(i), depoints.get(j));
//    			tmp.records.add(depoints.get(i));
//    			tmp.records.add(depoints.get(j));
//    			tmp.cnt = amount.get(depoints.get(i)) + amount.get(depoints.get(j));
//    			lines.add(tmp);
//    		}
//        }
//    	
//    	Collections.sort(lines, new LineComparator());
//    	Line cur = lines.get(0);
//    	int max = cur.cnt;
//    	for (i = 1; i < lines.size(); ++i) {
//    		//System.out.format("cur = %si = %ssame = %b\n\n", cur, lines.get(i), cur.sameLine(lines.get(i)));
//    		if (lines.get(i).sameLine(cur)) {
//    			for (Point p : lines.get(i).records) {
//    				if (!cur.records.contains(p)) {
//    					cur.records.add(p);
//    					cur.cnt += amount.get(p);
////    					System.out.println("amount = " + cur.cnt);
//    				}
//    			}
//    		} else {
//    			if (cur.cnt > max) max = cur.cnt;
//    			cur = lines.get(i);
//    		}
//    	}
//    	return Math.max(cur.cnt, max);
//    }
	
	int _(int x, int y) {
        return x;
    }
    int gcd(int a, int b) {
        a = _(b, b = a);
        while (b != 0) {
            a = a%b;
            a = _(b, b = a);
        }
        return a;
    }
    String p2s(Point p) {
        return String.format("x%dy%d", p.x, p.y);
    }
    String l2s(int a, int b, int c) {
        return String.format("a%db%dc%d", a, b, c);
    }
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        Map<String, Integer> count = new HashMap<String, Integer>();
        Map<String, Integer> ret = new HashMap<String, Integer>();
        Map<String, Set<String> > records = new HashMap<String, Set<String> >();
        List<Point> upoints = new ArrayList<Point>();
        String tmp, tmp2;
        for (Point p : points) {
            tmp = p2s(p);
            if (count.containsKey(tmp)) count.put(tmp, count.get(tmp)+1);
            else {
                count.put(tmp, 1);
                upoints.add(p);
            }
        }
        if (upoints.size() == 1) return points.length;
        int a, b, c, d, maxv = 0;
        for (int i = 0; i < upoints.size(); ++i) {
            for (int j = i+1; j < upoints.size(); ++j) {
                a = upoints.get(j).y - upoints.get(i).y;
                b = upoints.get(i).x - upoints.get(j).x;
                c = upoints.get(i).y * (upoints.get(j).x - upoints.get(i).x) + 
                    upoints.get(i).x * (upoints.get(i).y - upoints.get(j).y);
                
                d = gcd(Math.abs(a), Math.abs(b));
                d = gcd(d, Math.abs(c));
                a /= d;
                b /= d;
                c /= d;
            
//                System.out.format("%d %d %d %s %s\n", a, b, c, p2s(upoints.get(i)), p2s(upoints.get(j)));
                tmp = l2s(a, b, c);
                if (ret.containsKey(tmp)) {
                    tmp2 = p2s(upoints.get(i));
                    if (!records.get(tmp).contains(tmp2)) {
                        records.get(tmp).add(tmp2);
                        ret.put(tmp, ret.get(tmp) + count.get(tmp2));
                    }
                    tmp2 = p2s(upoints.get(j));
                    if (!records.get(tmp).contains(tmp2)) {
                        records.get(tmp).add(tmp2);
                        ret.put(tmp, ret.get(tmp) + count.get(tmp2));
                    }
                } else {
                    Set<String> ss = new HashSet<String>();
                    tmp2 = p2s(upoints.get(i));
                    ss.add(tmp2);
                    a = count.get(tmp2);
                    tmp2 = p2s(upoints.get(j));
                    ss.add(tmp2);
                    a += count.get(tmp2);
                    records.put(tmp, ss);
                    ret.put(tmp, a);
                }
                if (maxv < ret.get(tmp)) maxv = ret.get(tmp);
            }
        }
        return maxv;
    }
    
    public static void main(String[] args) {
    	//Point[] points = new Point[]{new Point(0, 0), new Point(0, 0), new Point(0, 0)};
    	//Point[] points = new Point[]{new Point(12,3), new Point(3, 1),new Point(3, 1), new Point(-6,-1)};
//    	Point[] points = new Point[]{new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),new Point(-30,-102),
//    			new Point(230,709),new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),new Point(-161,-481),
//    			new Point(207,639),new Point(23,79),new Point(-230,-691),new Point(-115,-341),new Point(92,289),new Point(60,336),new Point(-105,-467),new Point(135,701),
//    			new Point(-90,-394),new Point(-184,-551),new Point(150,774)};
    	Point[] points = new Point[]{new Point(0, 0), new Point(-1, -1), new Point(2, 2)};
    	Solution s = new Solution();
    	System.out.println(s.maxPoints(points));
    }
}
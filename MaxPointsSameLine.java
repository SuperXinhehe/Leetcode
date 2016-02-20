import java.util.*;
import java.util.stream.*;
public class MaxPointsSameLine {
	// get a list of points that in the same line
	public Set<Point> getPoints(List<Point> points) {
		HashMap<Set<Double>,Set<Point>> hm = new HashMap<Set<Double>,Set<Point>>();
		double k;
		double b;
		Set<Double> linekey;
		Set<Point> l;
		Point p1;
		Point p2;
		for(int i=0;i<points.size()-1;i++) {
			for(int j=i+1;j<points.size();j++) {
				p1 = points.get(i);
				p2 = points.get(j);
				if(p1.x-p2.x == 0) {
					k = 100;
					b = p1.x;
				}
				else {
					k = (p1.y - p2.y)/(p1.x - p2.x);
					b = p1.y - p1.x*(p1.y - p2.y)/(p1.x - p2.x);
				}
				linekey = new HashSet<Double>();
				linekey.add(k);
				linekey.add(b);
				if(hm.containsKey(linekey)) {
					l = hm.get(linekey);
					l.add(p1);
					l.add(p2);
					hm.put(linekey,l);
				}
				else {
					l = new HashSet<Point>();
					l.add(p1);
					l.add(p2);
					hm.put(linekey,l);
				}
			}
		}
		Set<Point> out = hm.values().stream().sorted((s1,s2) -> s1.size() > s2.size() ? -1 : 1).findFirst().get();
		// for(Map.Entry entry:hm.entrySet()) {
		// 	System.out.println(entry.getKey());
		// 	System.out.println(entry.getValue().toString());
		// }
		//System.out.println(out);
		return out;
	}
	public static void main(String args[]) {
		MaxPointsSameLine mpsl = new MaxPointsSameLine();
		List<Point> l = new ArrayList<Point>();
		l.add(new Point(1,-1));
		l.add(new Point(2,0));
		l.add(new Point(4,2));
		l.add(new Point(2,-5));
		l.add(new Point(0,-2));
		
		Set<Point> s = mpsl.getPoints(l);
		s.stream().forEach(p -> System.out.print("("+p.x+","+p.y+")"));
		System.out.println();
	}
}
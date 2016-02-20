import java.util.*;

public class MergeIntervals {

	public List<Inteval> merge(List<Inteval> intervals) {
		List<Inteval> l = new ArrayList<Inteval>();
		Interval pre = new Interval();
		pre = intervals.get(0);
		for(int i=1;i<intervals.size();i++) {
			int start = pre.start;
			int end = pre.end;
			Interval cur = intervals.get(i);
			int s = cur.start;
			int e = cur.end;
			if(end>s && end<e) {
				pre.start = start;
				pre.end = e;
				//l.add(pre);
			}
			else {
				l.add(pre);
				pre = new Interval(s,e);
			}

		}
		return l;

	}
	public static void main(String args[]) {

	}
}
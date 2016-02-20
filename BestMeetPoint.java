import java.util.*;

public class BestMeetPoint {
	// return the distance
	// print out the meeting point
	public static int MeetPoint(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Vector<Integer> ii = new Vector<Integer>();
		Vector<Integer> jj = new Vector<Integer>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == 1) {
					ii.add(i);
					jj.add(j);
				}
			}
		}
		Collections.sort(jj);
		int c = ii.size();
		int s = 0;
		int io = ii.get(c/2);
		int jo = jj.get(c/2);
		for(int i:ii) s+= Math.abs(i-io);
		for(int j:jj) s+= Math.abs(j-jo);
		System.out.println("Meeting Point is: ("+io+","+jo+").");
		return s;

	}
	public static void main(String args[]) {
		int[][] multi = new int[][] {
			{1,0,0,0,1},
			{0,0,0,0,0},
			{0,1,0,0,1}
		};
		System.out.println(MeetPoint(multi));
	}
}
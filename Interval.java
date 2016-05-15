public class Interval {
	int left = 0;
	int right = 0;

	public Interval(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public boolean overlap(Interval interval2) {
		if(interval2.right <= left || interval2.left >= right) {
			return false;
		}
		else return true;
	}
}
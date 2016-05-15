import java.util.*;

public class April262016 {
	// sliding window with at most two characters..
	public String longestStrMost2 (String input) {
		int start = 0;
		int maxLen = 0;

		// key: letter; value: the index of the last occurence
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if (map.size() == 2 && !map.containsKey(c)) {
				// pick the character with the leftmost last occurence.
				char charEndsMostLeft = ' ';
				int minLast = input.length();
				for (char ch: map.keySet()) {
					int last = map.get(ch);
					if (last < minLast) {
						minLast = last;
						charEndsMostLeft = ch;
					}
				}
				map.remove(charEndsMostLeft);
				start = minLast + 1;
			}
			map.put(c,i);
			maxLen = Math.max(maxLen,i-start+1);
		}
		return maxLen;
	}
	//

	public int findPeakElement2(int[] num) {
		int length = num.length;
		if (length == 1) {
			return 0;
		}
		int low = 0, high = length - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if ((mid == 0) || num[mid] >= num[mid - 1])
				(mid == length - 1 || num[mid] >= num[mid+1])) {
				return mid;

			} else if (mid > 0 && num[mid - 1] >= num[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return mid;
	}
	// count number of ways of step 1,2,3
	
	
}
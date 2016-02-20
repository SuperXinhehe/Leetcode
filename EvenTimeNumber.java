// class to find the first element that appears an even number of times
import java.util.*;

public class EvenTimeNumber {
	// method to use linear time get the element
	public <T> T getNumber(T[] input) {
		LinkedHashMap<T,Integer> hm = new LinkedHashMap<T,Integer>();
		int startv = 1;
		int v;
		// use linkedhashmap to store the appearing time and 
		// maintain the order of insertion
		for(T ele: input) {
			if(hm.containsKey(ele)) {
				v = hm.get(ele);
				v = v + 1;
				hm.put(ele,v);
			}
			else {
				hm.put(ele,startv);
			}
		}
		for(Map.Entry<T,Integer> entry: hm.entrySet()) {
			if(entry.getValue() % 2 == 0) {
				return entry.getKey();
			}
		} 
		return (T) Integer.valueOf(-1);
	}

	public static void main(String args[]) {
		EvenTimeNumber tn = new EvenTimeNumber();
		// Integer[] input = {2,1,3,3,5,6,3,1,5};
		String[] input = {"this","this","this","and","so","and","so"};
		System.out.println(tn.getNumber(input));
	}

}
import java.util.*;

public class LargestRecHistogram {

    public static int largestRectangleArea(int[] height) {
    	TreeMap<Integer,Integer> hm = new TreeMap<Integer,Integer>();
    	List<Integer> vals = new ArrayList<Integer>();
    	int counter;
    	int key;
        for(int i=0;i<height.length;i++) {
        	int curval = height[i];
        	List<Integer> keys = new ArrayList<>(hm.keySet());
        	counter = 1;
        	for(int j=keys.size()-1;j>0;j--) {
        		// counter = 1;
        		key = keys.get(j);
        		// hm.put(key,counter);
        		if(key <= curval) {
        			hm.put(key,hm.get(key) + 1);
        		}
        		else {
        			counter++;
        			int v = hm.get(key);
        			System.out.println(v*key);
        			System.out.println("key: "+key+", value: "+v);
        			vals.add(v*key);
        			hm.remove(key);
        		}
        	}
        	hm.put(curval,counter);
        	System.out.println("current height: "+curval+", and width: "+counter);
        }
        for(Map.Entry<Integer,Integer> set:hm.entrySet()) {
        	Integer k = set.getKey();
        	Integer v = set.getValue();
        	System.out.println("key: "+k+", value: "+v);
        	System.out.println(k*v);
        	vals.add(k*v);
        }
        return Collections.max(vals);
    }
	public static void main(String args[]) {
		int[] height = {4,2,3};
		int i = largestRectangleArea(height);
		System.out.println(i);
	}
}
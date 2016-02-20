import java.util.*;

public class LRUCache {

	private int capacity;
	private LinkedHashMap<Integer,Integer> hm;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.hm = new LinkedHashMap<Integer,Integer>();
	}

	// get the value of the key if the key exist in the cache otherwise return -1;
	public int get(int key) {
		if(hm.keySet().contains(key)) {
			return hm.get(key);
		}
		else return -1;
	}

	// add the key and value if the capacity is not 
	// if the key is already existed, drop the execution
	public void set(int key, int value) {
		if(!hm.keySet().contains(key)) {
		if(hm.size() + 1 <= capacity) {
			System.out.println("Key="+key+", Value="+value+" is added");
			hm.put(key,value);
		}
		else {
			List<Integer> keys = new ArrayList<Integer>(hm.keySet());
			int k = keys.get(0);
			System.out.println(k +" is removed due to the overloading.");
			hm.remove(k);
			System.out.println("Key="+key+", Value="+value+" is added");
			hm.put(key,value);
		}
		}
		else System.out.println("Execution failed to execute since "+key+" is already present.");
	}

	public static void main(String args[]) {
		LRUCache lru = new LRUCache(3);
		lru.set(2,3);
		lru.set(1,2);
		System.out.println("Value is: "+lru.get(2));
		lru.set(1,4);
		lru.set(4,1);
		System.out.println("Value is: "+lru.get(3));
	}
}
import java.util.*;

public class MaxNumber {
	public List<Integer> getFirstKMaxNum(Integer[] a1, Integer[] a2, int k) {
		int size1 = a1.length;
		int size2 = a2.length;
		Integer[] out;
		List<Integer> l;
		if(size1+size2 == k) {
			out = new Integer[k];
			System.arraycopy(a1,0,out,0,size1);
			System.arraycopy(a2,0,out,size1,size2);
			return Arrays.asList(out);
		}
		else {
			// sorting each array using 2logn running time
			List<Integer> la1 = sort(Arrays.asList(a1));
			List<Integer> la2 = sort(Arrays.asList(a2));
			l = merge(la1,la2);
			l = l.subList(0,k);
			return l;
		}
	}
	// merge sort in descending order
	public List<Integer> sort(List<Integer> inputl) {
		int mid;
		List<Integer> l1;
		List<Integer> l2;
		List<Integer> out = new ArrayList<Integer>();
		if(inputl.size() == 2) {
			if(inputl.get(1) > inputl.get(0)) {
				out.add(inputl.get(1));
				out.add(inputl.get(0));
			}
			else out = inputl;
		}
		else if(inputl.size() < 2) {
			out = inputl;
		}
		else {
			mid = inputl.size()/2;
			l1 = sort(inputl.subList(0,mid));
			l2 = sort(inputl.subList(mid,inputl.size()));
			int bound = l1.size() + l2.size();
			out = merge(l1,l2);
		}
		return out;
	}
	// merging two sorted lists
	public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
		List<Integer> out = new ArrayList<Integer>();
		int k1 = 0;
		int k2 = 0;
		while(k1 < l1.size() && k2 < l2.size()) {
			if(l1.get(k1) >= l2.get(k2)) {
				out.add(l1.get(k1));
				k1++;
			}
			else {
				out.add(l2.get(k2));
				k2++;
			}			
		}
		if(k1 == l1.size()) {
			for(int t = k2;t<l2.size();t++) {
				out.add(l2.get(t));
			}
		}
		else if(k2 == l2.size()) {
			for(int t = k1;t<l1.size();t++) {
				out.add(l1.get(t));
			}
		}
		return out;
	}
	public static void main(String args[]) {
		MaxNumber mn = new MaxNumber();
		Integer[] a1 = {3,4,6,5};
		Integer[] a2 = {9,1,2,5,8,3};

		List<Integer> l = mn.getFirstKMaxNum(a1,a2,5);
		System.out.println(l.toString());
	}
}
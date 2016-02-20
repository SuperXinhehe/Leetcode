import java.util.*;
import java.util.stream.Collectors;

public class NumInversions {
  LinkedHashMap<Integer,Integer> counts;
  
  public List<Integer> countSmaller(int[] nums){
    counts = new LinkedHashMap<Integer,Integer>();
    for (int num:nums) {
      counts.put(num,0);
    }
    List<Integer> copy = Arrays.stream(nums).boxed().collect(Collectors.toList());
    Queue<Integer> sorted = mergeSort(copy);
    // for(Map.Entry<Integer,Integer> entry: counts.entrySet()) {
    //   System.out.println("key, "+entry.getKey().toString()+" value "+entry.getValue().toString());
    // }
    return new ArrayList<Integer>(counts.values());
  }
  public Queue<Integer> mergeSort(List<Integer> inputl) {
    Queue<Integer> s = new LinkedList<Integer>();
    if(inputl.size() == 1) {
      s.add(inputl.get(0));
    }
    else if(inputl.isEmpty()){
      // return s;
    }
    else {
      int mid = inputl.size()/2;
      Queue<Integer> s1 = mergeSort(inputl.subList(0,mid));
      Queue<Integer> s2 = mergeSort(inputl.subList(mid,inputl.size()));
      s = merge(s1,s2);      
    }
    return s;
  }
  public Queue<Integer> merge(Queue<Integer> s1, Queue<Integer> s2) {
     int t;
     int v;
     Queue<Integer> mergedSK = new LinkedList<Integer>();
     if(s1.size() > s2.size()) {
       t = s2.size();
     }
     else t = s1.size();
     for (int i=0;i<t;i++) {
     // while(!s1.isEmpty() && !s2.isEmpty()) {
     for(Integer ele: s1) {
     }
       if(s1.peek()<s2.peek()) {
          mergedSK.add(s1.poll());
       }
       else {
        for(Integer ele: s1) {
          v = counts.get(ele) + 1;
          counts.put(ele,v);
        }
        mergedSK.add(s2.poll());
       }
     }
     if(s1.isEmpty()) {
      for(Integer ele: s2) {
        mergedSK.add(s2.poll());
      }
     }
     else if(s2.isEmpty()) {
      for(Integer ele: s1) {
        mergedSK.add(s1.poll());
      }
     }
    return mergedSK;
  }
  public static void main(String args[]) {
    int[] nums = {5,2,6,1};
    NumInversions ni = new NumInversions();
    List<Integer> out = ni.countSmaller(nums);
    out.forEach(ele->System.out.print(ele+", "));
    System.out.println();
  }
}


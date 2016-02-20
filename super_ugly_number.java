import java.util.*;

public class super_ugly_number {
   public PriorityQueue<Integer> pq = new PriorityQueue();
   public void nthUglyNumber(int n,int[] primes) {
      int iterator = 0;
      List<Integer> l = new ArrayList();
      HashMap<Integer,Integer> hm = new HashMap();
      for(int i=0;i<primes.length;i++) {
         hm.put(primes[i],1);
      }
      pq.offer(1);
      for(int i=0;i<n;i++) {
        for(int j=0;j<primes.length;j++) {
          int v = hm.get(primes[j]);
          pq.offer(primes[j]*v);
          v++;
          hm.put(primes[j],v);
        }      
      }
      for(int k=0;k<n;k++) {
        System.out.println("peek: "+pq.poll());
      }
   }

   public static void main(String args[]) {
      super_ugly_number un = new super_ugly_number();
      int[] primes = {2,3,11};
      un.nthUglyNumber(8,primes);      
   }
}

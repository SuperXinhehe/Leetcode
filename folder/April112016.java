import java.util.*;

public class April112016 {

      public boolean isHappy(int n) {
        if(n==1) return true;
        if(n!=1 && n<10) n = n*n;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int num = n;
        while(num > 0) {
            stack.push(num % 10);
            num = num / 10;
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum = sum + stack.getFirst()*stack.pop();
        }
        if(sum == 1) return true;
        else return isHappy(sum);
    }

    public static void main(String[] args) {
      April112016 a = new April112016();
      System.out.println(a.isHappy(7));

    }  

}

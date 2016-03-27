import java.util.*;

public class Reverse {
       public int reverse(int x) {
        String str = Integer.toString(x);
        String out = "";
        int start = 0;
        if(str.charAt(0)=='-') {
            // start = 1;
            str = str.substring(1,str.length());
            start = 1;
        }
        // for(int i=str.length()-1;i>=start;i--) {
        //     out = out + str.charAt(i);
        // }
        out = new StringBuilder(str).reverse().toString();
        if(start==1) out = "-" + out;
        return Integer.parseInt(out);
    }
    public static void main(String[] args) {
      Reverse r = new Reverse();
      System.out.println(r.reverse(123));
    }

}

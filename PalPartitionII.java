import java.util.*;

public class PalPartitionII {
    public int minCut(String s) {
        //if(checkPalindrome(s)) return 0;
        int[] opt = new int[s.length() + 1];
        opt[0] = 0;
        int checker;
        int minv;
        int v;
        for(int j=1;j<=s.length();j++) {
            minv = Integer.MAX_VALUE;
            for(int i=0;i<j;i++) {
                if(checkPalindrome(s.substring(i,j))) {
                    if(i==0) checker = 0;
                    else checker = 1;
                }
                else {
                    checker = j-i;
                }
                v = opt[i] + checker;
                if(v < minv) {
                    minv = v;
                }
            }
            opt[j] = minv;
        }
        return opt[s.length()];
    }
    // method to check if the string is palindrome
    // using linear time
    public boolean checkPalindrome(String str) {
        if(str.length() <= 1) return true;
        int mid = str.length()/2;
        String h1 = str.substring(0,mid);
        String h2 = str.substring(mid,str.length());
        String rh2 = new StringBuffer(h2).reverse().toString();
        if(h1.equals(rh2)) return true;
        else return false;
    }
}
package Algorithm;

import java.util.*;
public class WordBreak {
    public static Boolean[] wordBreak(String s,List<String> dict){
        Boolean[] out = new Boolean[s.length()];
        for(int i=0;i<s.length();i++) {
            if(dict.contains(s.substring(0,i+1))) {
                out[i] = true;
            }
            else if(!dict.contains(s.substring(0,i+1))){
                out[i] = false;
                for(int k=0;k<i;k++) { 
                    if(out[k]==true && dict.contains(s.substring(k+1,i+1))){
                        out[i] = true;
                        break;
                    }
                }   
            }
            else out[i] = false; 
        }
        return out;
    }
    public static void main(String args[]){
        List<String> dict = Arrays.asList("leet","code","is","cool");
        String s = "leetcodeiscool";
        Boolean[] out = wordBreak(s,dict);
        //System.out.println(Arrays.asList(out));
        System.out.println(out[out.length-1]);
    }
}

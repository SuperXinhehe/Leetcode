package Algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class twoSum {
    public static Integer[] TwoSum(Integer[] input,int target) {
        HashMap<Integer,Integer> map = new HashMap();
        Integer[] output = {};
        for(int i=0;i<input.length;i++) {
            int diff = target - input[i];
            map.put(input[i],i+1);
            //System.out.println(input[i]+", "+i);
            if(map.containsKey(diff)){
                output = new Integer[] {map.get(diff),i+1};
                return output;
            }   
        }
        return output;
    }
    public static void main(String args[]) {
        int target = 9;
        Integer[] input = {1,2,5,7,10,11};
        Integer[] out = TwoSum(input,target);
        List<Integer> outl = Arrays.asList(out);
        outl.forEach(ele->System.out.println(ele));
    }
}
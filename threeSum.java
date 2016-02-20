package Algorithm;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class threeSum {
    public static List<List<Integer>> threeSum(Integer[] input) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Arrays.sort(input);
        int i = 0;
        int j = input.length-1;
        int k = 0;
        while(i<j && j-i>=2) {
            System.out.println("i: "+i+", j:"+j+", k:"+k);
            if(input[i]+input[j]<0){
                k = j-1;
                if(input[i]+input[j]+input[k]==0){
                    List<Integer> out = Arrays.asList(input[i],input[k],input[j]);
                    output.add(out);
                    i = i+1;
                    j = j-1;
                }
                else if(input[i]+input[j]+input[k]<0) {
                    // this case means that the negative side is too big
                    // therefore change shorter the left hand side scope.
                    i = i+1;
                }
                else if(input[i]+input[j]+input[k]>0) {
                    j = j-1;
                    // the right side positive one is too big
                }
            }
            else if(input[i]+input[j]>0) {
                k = i + 1;
                if(input[i]+input[j]+input[k]==0){
                    List<Integer> out = Arrays.asList(input[i],input[k],input[j]);
                    output.add(out);
                    i = i+1;
                    j = j-1;
                }
                else if(input[i]+input[j]+input[k]<0) {
                    // this case means that the negative side is too big
                    // therefore change shorter the left hand side scope.
                    i = i+1;
                }
                else if(input[i]+input[j]+input[k]>0) {
                    j = j-1;
                    // the right side positive one is too big
                }
            }
            else if (input[i]+input[j]==0) {
                // only the sum of ith and jth elements equals to 0;
                // we go though the whole input array check if 0 is included;
                // in this case take O(n^2);
                // therefore we can pre get the index of zero and its index or not;
                List<Integer> inputl = Arrays.asList(input);
                if(inputl.contains(0)){
                    k = inputl.indexOf(0);
                    List<Integer> out = Arrays.asList(input[i],input[k],input[j]);
                    output.add(out);
                    i = i+1;
                    j = j-1;
                }
                else {
                    i = i+1;
                    j = j-1;
                }
            }
        }
        return output;
        
    }
    public static void main(String args[]) {
        Integer[] input = new Integer[] {-4,-1,-1,0,1,2};
        List<List<Integer>> out = threeSum(input);
        System.out.println(out.toString());
    }
}

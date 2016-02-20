package Algorithm;

import java.util.Arrays;
/**
 *
 * @author XinhelovesMom
 */
public class stockI {
    public static int[] MaxProfit(int[] input) {
        int[] output = new int[input.length];
        output[0] = 0;
        for(int i=1;i<input.length;i++) {
            output[i] = Math.max(output[i-1],returntheMax(Arrays.copyOfRange(input, i+1, input.length+1))-input[i]);
        }
        //return returntheMax(output);
        return output;
    }
    public static int returntheMax(int[] input) {
        int max = input[0];
        for(int j=1; j<input.length;j++) {
            if(input[j]>max){
                max = input[j];
            }
        }
        return max;
    }
    public static void main(String args[]) {
        int[] input = new int[]{6,7,9,3,2,10,4};
        //MaxProfit(input);
        //System.out.println(MaxProfit(input));
        System.out.println(Arrays.toString(MaxProfit(input)));
    }
    
}

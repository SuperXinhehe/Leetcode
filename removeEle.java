import java.util.*;

public class removeEle {

	public static int[] removeElement(int[] input,int index) {
		if(index>input.length) return input;
		int[] out = new int[input.length-1];
		for(int i=0;i<index;i++) {
			out[i] = input[i];
		}
		for(int i=index;i<input.length-1;i++) {
			out[i] = input[i+1];
		}
		return out;
	}
	public static void main(String args[]) {
		int[] input = {1,2,3,4,5,6};
		int k = 3;
		System.out.println(Arrays.toString(removeElement(input,k)));

	}	
}
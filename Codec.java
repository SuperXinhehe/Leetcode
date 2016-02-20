import java.util.*;
public class Codec  {
	//Encodes a list of strings to a single string.
   public String encode(List<String> strs) {
   		StringBuilder output = new StringBuilder();
   		for(String str: strs) {
   			output.append(String.valueOf(str.length()) + "#");
   			output.append(str);
   		}
   		return output.toString();
   }
   // Decodes a string to a list of strings
   public List<String> decode(String s) {
   	    List<String> res = new LinkedList<String>();
   	    int start = 0;
   	    while(start < s.length()) {
   	    	int idx = s.indexOf("#", start);
   	    	int size = Integer.parseInt(s.substring(start,idx));
   	    	res.add(s.substring(idx+1, idx+size+1));
   	    	// update index
   	    	start = idx + size + 1;
   	    }
   	    return res;
   }
   public static void main(String args[]) {
   		List<String> strl = Arrays.asList("Xinhe Loves Mom","Right!","Love is a good thing!");
   		Codec c = new Codec();
   		System.out.println(c.encode(strl));
   }

}
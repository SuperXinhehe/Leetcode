import java.util.*;
public class April042016 {
	// gg and fb...
public String fractionToDecimal(int numerator, int denominator) {
	if (numerator == 0)
		return "0";
	if (denominator == 0)
		return "";
 
	String result = "";
 
	// is result is negative
	if ((numerator < 0) ^ (denominator < 0)) {
		result += "-";
	}
 
	// convert int to long
	long num = numerator, den = denominator;
	num = Math.abs(num);
	den = Math.abs(den);
 
	// quotient 
	long res = num / den;
	result += String.valueOf(res);
 
	// if remainder is 0, return result
	long remainder = (num % den) * 10;
	if (remainder == 0)
		return result;
 
	// right-hand side of decimal point
	HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	result += ".";
	while (remainder != 0) {
		// if digits repeat
		if (map.containsKey(remainder)) {
			int beg = map.get(remainder); 
			String part1 = result.substring(0, beg);
			String part2 = result.substring(beg, result.length());
			result = part1 + "(" + part2 + ")";
			return result;
		}
 
		// continue
		map.put(remainder, result.length());
		res = remainder / den;
		result += String.valueOf(res);
		remainder = (remainder % den) * 10;
	}
 
	return result;
}
	// find all the unique triplets in array which gives the sum of zero
    public List<List<Integer>> threeSum(int[] input) {
        if(input.length<3||input==null) return new ArrayList<List<Integer>>();

        List<List<Integer>> out = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();

        for(int k = 0;k<input.length-3;k++) {
            int i = k + 1;
            int j = input.length - 1;
            System.out.println(input[i]+" ");
            System.out.print(input[j]+" ");
            System.out.print(input[k]);
            while (i < j) {
                int sum = input[i] + input[j] + input[k];
                if(sum == 0) {
                    ArrayList<Integer> inner = new ArrayList<Integer>();
                    inner.add(input[i]);
                    inner.add(input[j]);
                    inner.add(input[k]);

                    if(!hs.contains(inner)) {
                        out.add(new ArrayList<Integer>(inner));
                        hs.add(inner);
                    }

                i++;
                j--;

                }else if (sum > 0) {
                    j--;

                }else {
                    i++;
                }
            }
        }
        return out;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(nums == null||nums.length <=1 || t<0||k<1) return false;
    	TreeSet<Integer> set = new TreeSet<Integer>();
    	for (int i=0;i<nums.length;i++) {
    		int temp = nums[i];
    		if((set.floor(temp)!=null && set.floor(temp+t)>=temp)||(set.ceiling(temp)!=null && set.ceiling(temp)-t<=temp)) {
    			return true;
    		}
    		set.add(temp);
    		if(i>=k) set.remove(nums[i-k]);
    	}
    	return false;

    }

	public static void main(String[] args) {
		April042016 a = new April042016();
		int[] input = {-1,0,1,2,-1,-4};
		List<List<Integer>> out = a.threeSum(input);
		for (List<Integer> o: out) {
			o.forEach(ele->System.out.print(ele+", "));
		}
		System.out.println();
	}


}
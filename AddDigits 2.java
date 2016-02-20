import java.util.*;

public class AddDigits{
	public int addDigits(int num) {
		if(num / 10 == 0) return num;
		else {
			int degree = 1;
			int new_num = num;
			int out = 0;
			while(new_num > 0) {
				out = out + new_num % 10;
				new_num = new_num / 10;
			}
			return addDigits(out);
		}
	}
	public int pow(int base,int power) {
		int out = 1;
		for(int i=0;i<power;i++) {
			out = out * base;
		}
		return out;
	}
	public static void main(String args[]) {
		AddDigits ad = new AddDigits();
		System.out.println(ad.addDigits(19));

	}
}
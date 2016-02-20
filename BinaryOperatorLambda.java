import java.util.*;
import java.util.function.BinaryOperator;

public class BinaryOperatorLambda{
	
	public static void main(String[] args){
		BinaryOperator<String> bi = (s1,s2) -> s1+s2;
		String result = bi.apply("just ","java 8");
		System.out.println(">" + result);
	}
}
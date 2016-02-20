import java.util.function.Function;
public class AndThen {
	public static void main(String args[]) {
		Function<String,Integer> toInteger = Integer::valueOf;
		Function<String,String> backtoStr = toInteger.andThen(String::valueOf);
		System.out.println(backtoStr.apply("123"));
	}
}
import java.util.*;

public class AllMatchStream {
	public static void main(String args[]) {
		List<String> strCollect = Arrays.asList(new String[] {"add2","ddd2","aaa2"});
		boolean allStartWithA = strCollect.stream().allMatch((s) -> s.startsWith("a"));
		System.out.println(allStartWithA);
	}
}
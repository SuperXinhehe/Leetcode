public class Permutes {
	public void permutations(String str) {
		permutate("",str);
	}
	public void permutate(String prefix, String str) {
		int n = str.length();
		if(n==0) {
			System.out.println(prefix);
		}
		else {
			for(int i=0;i<n;i++) {
				permutate(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
			}
		}
	}
	public static void main(String[] args) {
		String str = "this";
		Permutes p = new Permutes();
		p.permutations(str);
	}
}
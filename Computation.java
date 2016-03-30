import java.util.*;

public class Computation {

	public int computeExpression(String[] args) {
		Stack<String> sk = new Stack<String>();
		String operations = "+-*/";
		for(String ele: args) {
			// if this is a value then add to stack
			if(!operations.contains(ele)) {
				sk.push(ele);
			}
			else {
				int a = Integer.parseInt(sk.pop());
				int b = Integer.parseInt(sk.pop());
				int out;
				switch(ele) {
					case "+":
						out = a + b;
						sk.push(String.valueOf(out));
					break;
					case "-":
						out = b - a;
						sk.push(String.valueOf(out));
					break;
					case "*":
						out = a * b;
						sk.push(String.valueOf(out));
					break;
					case "/":
						out = b / a;
						sk.push(String.valueOf(out));
					break;
						
				}
			}


		}
		return Integer.parseInt(sk.pop());

	}
	public static void main(String[] args) {
		Computation c = new Computation();
		String[] ags = {"2","1","+","3","*"};
		System.out.println(c.computeExpression(ags));
	}
	
}
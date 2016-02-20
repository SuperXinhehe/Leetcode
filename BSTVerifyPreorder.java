import java.util.Stack;
public class verifyPreorderBST {
    
    public static boolean verifyPreorder(int[] input) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> inorder = new Stack();
        for(int p: input) {
            if(!inorder.isEmpty() && p < inorder.get(inorder.size() - 1)) {
                return false;
            }
            while(!stack.isEmpty() && p > stack.peek()) {
                inorder.add(stack.pop());
            }
            stack.add(p);
        }
        return true; 
    }
    public static void main(String args[]) {
        int[] input = new int[]{4,2,3,6,5};
        System.out.println(verifyPreorder(input));
    }
    
}
public class JumpGame {

	public boolean checkGame(int[] input) {
		int move;
		int maxmove;
		int target = input.length - 1; 
		int curind = 0;
		maxmove = input[curind];
		// for(int i=0;i<move;i++) {
		while(maxmove != 0) {
			if(curind == target) {
				return true;
			}
			else {
				curind++;
				move = input[curind] + curind;
				if(move > maxmove) {
					maxmove = input[curind];
				}
			}
			maxmove--;
		}
		return false;
	}
	public static void main(String args[]) {
		int[] input = {3,3,1,0,4};
		JumpGame jg = new JumpGame();
		System.out.println(jg.checkGame(input));
	}
}
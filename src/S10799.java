import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		int totalPieces  = 0;

		for(int i = 0; i<str.length(); i++){
			char startBar = str.charAt(i);	
			if(startBar == '('){
				stack.push(startBar);
			}else{
				stack.pop();
				if(str.charAt(i - 1) == '('){
					totalPieces += stack.size();
				}else{
					totalPieces += 1;
				}
			}
		}
		System.out.println(totalPieces);
	}
}

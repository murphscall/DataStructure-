package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<String> stack = new Stack<>();

		boolean result  = validateFunc(s , stack);

		System.out.println(result);

	}

	static boolean validateFunc(String s, Stack stack){

		for (int i= 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push(s.charAt(i));
			}else{
				if(stack.isEmpty()){
					return false;
				}
				stack.pop();
			}
		}


		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}

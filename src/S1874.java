import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S1874 {

	public static void main(String[] args) throws IOException {
		// 입력 setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		// 입력 받는 수를 배열에 setting
		for(int i = 0 ; i<N ; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 현재 값은 1
		// boolean true
		int current = 1;
		boolean possible = true;


		// 입력 배열을 순회하며 현재 값이 배열의 현재 값보다 이하 인지 확인
		//
		for (int num : arr){
			while(current <= num){
				stack.push(current++);
				sb.append("+\n");
			}

			if(stack.peek() == num){
				stack.pop();
				sb.append("-\n");
			}else{
				possible = false;
				break;
			}
		}

		if(possible){
			System.out.println(sb);
		}else{
			System.out.println("NO");
		}






	}
}

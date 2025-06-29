import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import org.w3c.dom.ls.LSOutput;

public class G17298 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] A = new int[N];
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for(int i= 0; i< N; i++){
			while(!stack.isEmpty() && A[stack.peek()] < A[i]){
				result[stack.pop()] = A[i];
			}
			stack.push(i);
		}

		while(!stack.isEmpty()){
			result[stack.pop()] = -1;
		}

		for(int i=0; i < N; i++){
			sb.append(result[i]).append(' ');
		}

		System.out.println(sb);

	}

}

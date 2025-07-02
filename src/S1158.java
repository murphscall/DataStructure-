import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class S1158 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		ArrayDeque<Integer> deque = new ArrayDeque();
		StringBuilder result = new StringBuilder("<");

		for(int i = 1; i<=N; i++){
			deque.add(i);
		}
		while(deque.size() > 1){
			for (int i =1; i< K; i++){
				deque.offer(deque.poll());
			}
			result.append(deque.poll()).append(", ");
		}
		result.append(deque.poll()).append(">");
		System.out.println(result);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 빠른 문자열 계산
		String[] str = br.readLine().split(" "); // 첫 입력 데이터 분리
		List<Integer> list = new ArrayList<>(); // 결과 저장 리스트 선언
		Queue<Integer> queue = new LinkedList<>(); // 인원 저장

		int N = Integer.parseInt(str[0]); // N명의 사람
		int K = Integer.parseInt(str[1]); // K번째 사람

		for(int i=1; i<=N; i++){
			// 순회하며 큐에 N명 저장
			queue.offer(i);
		}
		// queue 가 전부 비워질 때 까지 반복
		while(!queue.isEmpty()){ // O(N)
			// K번째 사람 전까지 반복
			for(int i= 0; i < K -1;  i++ ){
				// K번째 사람 전에 모든 사람을 큐에서 제거하고 다시 뒤로
				queue.offer(queue.poll());
			}
			// 앞에 모든 사람을 뒤로 보냈으니 맨 앞은 K번쨰 사람
			// 큐에서 꺼내서 리스트 저장
			list.add(queue.poll());
		}


		// 출력 결과 세팅 => <?, ?, ?, ?, ?, ?, ?>
		// list 에는 제거된 순서대로 저장되어있다.
		sb.append("<");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i != list.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}


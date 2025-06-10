import java.io.*;
import java.util.*;

public class B1996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치

			// 큐에 [문서의 위치, 중요도] 쌍으로 저장
			Queue<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				queue.offer(new int[]{i, priority}); // 위치, 중요도
			}

			int printOrder = 0; // 출력 순서

			while (!queue.isEmpty()) {
				int[] current = queue.poll(); // 현재 맨 앞 문서
				boolean hasHigher = false;

				// 현재 문서보다 더 높은 중요도가 남아있는지 확인
				for (int[] doc : queue) {
					if (doc[1] > current[1]) {
						hasHigher = true;
						break;
					}
				}

				if (hasHigher) {
					queue.offer(current); // 뒤로 보냄
				} else {
					printOrder++; // 인쇄함

					// 타겟 문서였다면 출력 순서 출력
					if (current[0] == M) {
						System.out.println(printOrder);
						break;
					}
				}
			}
		}
	}
}

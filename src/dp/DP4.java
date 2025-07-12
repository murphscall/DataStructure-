package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

		// [수정] DP 테이블과 물건 정보를 저장할 배열 선언
		int[][] dp = new int[N + 1][K + 1];
		int[] W = new int[N + 1]; // 각 물건의 무게
		int[] V = new int[N + 1]; // 각 물건의 가치

		// [수정] 물건 정보 입력받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		// DP 테이블 채우기
		// i: 현재 고려하는 물건 번호
		for (int i = 1; i <= N; i++) {
			// w: 현재 가방의 허용 무게
			for (int w = 1; w <= K; w++) {

				// 만약 현재 물건(i)이 가방의 허용 무게(w)보다 무거워서 못 넣는 경우
				if (W[i] > w) {
					// i번째 물건을 넣는 선택지는 없으므로, i-1번째까지만 고려했을 때의 값을 그대로 가져온다.
					dp[i][w] = dp[i-1][w];
				}
				// 현재 물건(i)을 가방에 넣을 수 있는 경우
				else {
					// (선택 1) i번째 물건을 안 넣는 경우: dp[i-1][w]
					// (선택 2) i번째 물건을 넣는 경우: V[i] + dp[i-1][w - W[i]]
					// 두 선택 중 더 가치가 높은 쪽을 선택한다.
					dp[i][w] = Math.max(dp[i-1][w], V[i] + dp[i-1][w - W[i]]);
				}
			}
		}

		// N개의 물건을 모두 고려했고, 가방의 최대 무게가 K일 때의 최대 가치를 출력
		System.out.println(dp[N][K]);
	}
}
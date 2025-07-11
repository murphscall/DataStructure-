package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];

		// [수정 1] 입력받는 for문의 조건 수정
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// DP 테이블의 시작점(맨 위 꼭대기) 초기화
		dp[0][0] = arr[0][0];

		// [수정 2] DP 계산은 i=1 (두 번째 줄)부터 시작
		for (int i = 1; i < N; i++) {
			// [수정 3] 안쪽 for문의 조건 및 증가 변수 수정
			for (int j = 0; j <= i; j++) {
				if (j == 0) { // 맨 왼쪽
					dp[i][j] = dp[i-1][j] + arr[i][j];
				} else if (j == i) { // 맨 오른쪽
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				} else { // 중간
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				}
			}
		}

		// 마지막 줄에서 최댓값 찾기
		int max = 0;
		for (int j = 0; j < N; j++) {
			if (dp[N-1][j] > max) {
				max = dp[N-1][j];
			}
		}
		System.out.println(max);
	}
}
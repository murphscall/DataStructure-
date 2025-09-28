package dp;

// 계단 오르기
public class DP7 {

	public static int solution(int N) {
		if(N == 0) return 0;
		if(N == 1) return 1;
		if(N == 2) return 2;

		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 2;

		// 점화식 세우기
		// N번째 계단을 오르는 방법의 수는 N-1 번 째 방법의 수와 N-2 번째 방법의 수를 더한 값

		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[N];

	}

	public static void main(String[] args) {
		int result = solution(2);

		System.out.println(result);
	}
}

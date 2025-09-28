package dp;

// n번째 피보나치 수를 구해라

import java.util.Arrays;

public class DP6 {

	private static int[] dp;

	public static int solution(int N){

		if(N == 0) return 0;
		if(N == 1) return 1;

		// 값을 저장할 dp 배열을 선언한다.
		dp = new int[N+1];

		// 0번째 1번쨰를 초기화한다.
		dp[1] = 1;
		dp[2] = 2;

		for(int i =3; i <=N; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[N];
	}

	public static void main(String[] args) {

		int result = solution(5);

		System.out.println(result);
		System.out.println(Arrays.toString(dp));

	}


}

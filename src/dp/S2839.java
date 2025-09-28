package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2839 {

	// dp[N] = 해당 키로 수 의 최소 봉지 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int INF = 10000;
		int[] dp = new int[N + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;


		for(int i = 1; i <= N; i++){
			if(i >= 3 && dp[i-3] != INF){
				dp[i] = Math.min(dp[i] , dp[i-3] + 1);
			}
			if( i >= 5 && dp[i-5] != INF){
				dp[i] = Math.min(dp[i] , dp[i-5] + 1);
			}
		}

		System.out.println(dp[N] == INF ? -1 : dp[N] );

	}
}

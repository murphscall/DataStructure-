package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP8 {



	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		dp[0] = 0;

		for(int i = 0; i < N; i++){
			dp[i + 1] = Math.max(dp[i + 1], dp[i + 2]);
		}




	}
}

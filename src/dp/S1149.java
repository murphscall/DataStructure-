package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1149 {
	public static void main(String[] args) throws IOException {

		// dp[i] = n 번째 집까지 칠했을 때의 최소 비용

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[] dp = new int[3];


		for(int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0] = arr[0][0];
		dp[1] = arr[0][1];
		dp[2] = arr[0][2];

		for(int i = 1; i < N; i++) {
			int red = Math.min(dp[1],dp[2]) + arr[i][0];
			int green = Math.min(dp[0],dp[2]) + arr[i][1];
			int blue = Math.min(dp[0] , dp[1]) + arr[i][2];

			dp[0] = red;
			dp[1] = green;
			dp[2] = blue;
		}

		System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
	}
}

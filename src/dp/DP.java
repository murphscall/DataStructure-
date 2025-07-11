package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int[] dp = new int[X+1];




		for(int i =2 ; i<= X; i++){

			dp[i] = dp[i-1] + 1;

			if(i % 2 == 0){
				dp[i] = Math.min(dp[i],dp[i/2] + 1);
			}

			// 3. 3으로 나누어 떨어지는 경우, 더 작은 값으로 갱신
			if (i % 3 == 0) {
				// (기존 값)과 (i/3에서 1을 더한 값) 중 더 작은 것을 선택
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
		}

		System.out.println(dp[X]);


	}
}

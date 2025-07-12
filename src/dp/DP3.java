package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];

		for(int i = 0; i <N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];

		/*
		* dp = [
		*       [26],[40],[83]
		*       [83],[],[]
		*       [],[],[]
		*       ]
		* */

		for(int i = 1 ;  i < N; i++){
			for (int j = 0 ; j <3; j++){

				if(j==0){
					dp[i][j] = Math.min(dp[i-1][j+1] ,dp[i-1][j+2]) + arr[i][j];
				}else if(j == 2){
					dp[i][j] = Math.min(dp[i-1][j-1] , dp[i-1][j-2]) + arr[i][j];
				}else{
					dp[i][j] = Math.min(dp[i-1][j-1] , dp[i-1][j+1]) + arr[i][j];
				}
					/// 전에 칠한 집 + 전에 칠한 색깔 빼고 비용 젤작은집
			}
		}

		int result = Math.min(dp[N-1][0] , Math.min(dp[N-1][1],dp[N-1][2]));
		System.out.println(result);
	}
}

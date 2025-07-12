package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP5 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int [N];
		int[] A = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}






		for(int i = 0; i < N; i++){
			int target = A[i];
			for (int j = i+1;j < N; j++){
				if(A[j] < target){
					if(i == 0) {
						dp[i] = dp[i] + 1;
					}else{
						dp[i] = dp[i-1] + 1;
					}
				}
			}

		}


	}
}

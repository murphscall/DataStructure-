import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N+1];

		if(N ==0){
			System.out.println(0);
			return;
		}

		DP[0] = 0;
		DP[1] = 1;

		for (int i = 2; i <= N; i++){
			DP[i] = DP[i-1] + DP[i-2];
		}

		System.out.println(DP[N]);



	}
}

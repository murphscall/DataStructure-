import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int count =0;
		int sum  = 0;

		for(int end =0; end < N; end++){
			sum += arr[end];

			while(sum >= M){
				if(sum == M){
					count ++;
				}
				sum -= arr[start];
				start++;
			}
		}

		System.out.println(count);


	}
}

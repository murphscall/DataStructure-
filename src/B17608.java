import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 막대의 개수
		int[] arr = new int[N];
		int max = arr[N-1];
		int count = 0;



		for(int i = 0 ; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());

		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > max) {
				count++;        // 새로운 시야 확보
				max = arr[i];   // 시야 갱신 (더 높은 애가 기준이 됨)
			}
		}

		System.out.println(count);
	}
}

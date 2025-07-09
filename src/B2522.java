import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2522 {

	// 5번 반복문을 돈다.
	// 별을 1개씩 줄이면서 공백을 한개씩 늘린다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 0 ; i< N; i++){
			for (int j =0; j < N - i -1; j++){
				System.out.print(" ");
			}
			System.out.print("*".repeat(i + (i+1) ));
			System.out.println();
		}
	}
}

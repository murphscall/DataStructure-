import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			System.out.print(" ".repeat(i));
			System.out.println("*".repeat((2 * (N - i)) - 1));
		}                // 2 * (5 - i)  - 1

		for (int i = N - 2; i >= 0; i--) {
			System.out.print(" ".repeat(i));
			System.out.println("*".repeat((2 * (N - i)) - 1));
		}
	}
}

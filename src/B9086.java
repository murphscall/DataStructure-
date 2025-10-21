import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCaseNum; i++){
			StringBuilder sb = new StringBuilder();
			String[] input = br.readLine().split("");
			sb.append(input[0]);
			sb.append(input[input.length - 1]);

			System.out.println(sb);
		}

	}
}

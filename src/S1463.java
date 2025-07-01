import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		int count = 0;

		while(X > 1) {
			System.out.println(X / 2 == 0);
			if (X % 3 == 0) {
				X = X / 3;
				count++;
				continue;
			}
			if (X % 2 == 0) {
				X = X / 2;
				count ++;
				continue;
			}
			if(X > 1){
				X = X - 1;
				count ++;
			}
		}

		System.out.println(count);
	}
}

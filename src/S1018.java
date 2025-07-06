import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i ++){
			board[i] = br.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < N - 7 ; i++){
			for(int j = 0; j < M - 7; j++){
				int countW = 0;
				int countB = 0;

				for(int x = 0; x < 8; x ++){
					for(int y = 0; y < 8; y++){
						char currentChar = board[i+x][j+y];

						char expectedW = ((x+y) % 2 == 0) ? 'W' : 'B';
						if(currentChar != expectedW) countW++;
						char expectedB= ((x+y) % 2 == 0) ? 'B' : 'W';
						if(currentChar != expectedB) countB++;

					}
				}
				min = Math.min(min,Math.min(countW,countB));

			}
		}
		System.out.println(min);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2667 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int count = 0;

		for (int i = 0; i < map.length ; i++) {
			String line = br.readLine();
			for (int j = 0; j < map.length ; j++) {
				map[i][j] = line.charAt(i);
			}
		}






	}

	static void dfs(int i , int j){

	}
}

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1012 {

	static int[][] map ;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N;
	static int M;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());

		while(TestCase -- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로길이
			M = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추 위치 개수
			map = new int[N][M];
			visited = new boolean[N][M];



			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;

			}

			int count = 0 ;
			for(int i = 0 ; i < N; i ++){
				for (int j = 0; j <M ; j++) {
					if(!visited[i][j] && map[i][j] == 1){
						count++;
						dfs(i,j);

					}

				}
			}

			System.out.println(count);
		}

	}
	static void dfs(int currentX , int  currentY){
		visited[currentX][currentY] = true;

		for(int i = 0; i < 4; i++){
			int nextX = currentX + dx[i];
			int nextY = currentY + dy[i];

			if ( nextX < 0 || nextX >= N || nextY < 0 || nextY >= M ){
				continue;
			}

			if(!visited[nextX][nextY] && map[nextX][nextY] == 1){
				dfs(nextX , nextY);
			}

		}
	}
}

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1} ;
		int[][] miro = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0,1});

		// 미로 초기화
		for(int i = 0; i <  N; i++){
			String line = br.readLine();
			for(int j = 0; j < M; j++){
				miro[i][j] = line.charAt(j) - '0';
			}
		}
					while (!queue.isEmpty()){
						int[] now = queue.poll();
						int currentX = now[0];
						int currentY = now[1];
						int currentDist = now[2];

						if(currentX == N-1 && currentY == M-1){
							System.out.println(currentDist);
						}

						for(int k = 0; k < 4; k++){
							int nextX = currentX+ dx[k];
							int nextY = currentY + dy[k];

							if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
								continue;
							}

							if(!visited[nextX][nextY] && miro[nextX][nextY] == 1){
								visited[nextX][nextY] = true;
								queue.add(new int[]{nextX,nextY , currentDist+1});
							}

						}
					}
	}
}

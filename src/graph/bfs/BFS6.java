package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS6 {
	public static void main(String[] args) {
		int[][] picture = new int[][]{
			{1, 1, 0, 1, 1},
			{0, 1, 1, 0, 1},
			{0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1},
			{0, 0, 1, 0, 0},
			{0, 0, 1, 1, 1}
		};
		int m = 5;
		int n = 5;

		solution(m,n,picture);

	}

	public static int[] solution(int m , int n , int[][] picture){
		boolean[][] visited = new boolean[m][n];

		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};

		int numberOfArea = 0;
		int maxSizeOneAria=0;

		for (int i = 0; i <m ; i++) {
			for (int j = 0; j <n ; j++) {

				if(picture[i][j] == 1 && !visited[i][j]){
					numberOfArea++;

					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[]{i,j});
					visited[i][j] =true;

					int currentAreaSize = 1;

					while(queue.isEmpty()){
						int[] now = queue.poll();

						int currentX = now[0];
						int currentY  = now[1];

						for(int k = 0; k < 4; k++){
							int nextX = currentX + dx[k];
							int nextY = currentY + dy[k];

							if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n){
								continue;
							}

							if(!visited[nextX][nextY] && picture[nextX][nextY] == 1){
								visited[nextX][nextY] = true;
								queue.add(new int[]{nextX, nextY});
								currentAreaSize++;
							}
						}
					}
					maxSizeOneAria = Math.max(maxSizeOneAria, currentAreaSize);
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOneAria;
		return answer;
	}



}

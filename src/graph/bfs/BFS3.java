package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS3 {
	public static void main(String[] args) {
		int N = 5 , M =5;
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		int maps[][] = new int[][]{
			{1,0,1,1,1},
			{1,0,1,0,1},
			{1,0,1,1,1},
			{1,1,1,0,1},
			{0,0,1,1,1},
		};

		int result = solution(maps,N,M,visited);
		System.out.println(result);

	}


	static int solution(int[][] maps ,int N , int M, boolean[][] visited){

		int result = 0;
		int[] dx = new int[]{0,0,1,-1};
		int[] dy = new int[]{1,-1,0,0};



		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0,1});

		while(!queue.isEmpty()){

			int[] now = queue.poll();
			int currentX = now[0];
			int currentY = now[1];
			int currentDist = now[2];
			visited[currentX][currentY] = true;

			if(currentX == N-1 && currentY == M-1){
				return currentDist;
			}

			for(int i = 0; i < 4; i++){
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];

				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
					continue;
				}
				if(visited[nextX][nextY] == false && maps[nextX][nextY] == 1){
					queue.add(new int[]{nextX,nextY,currentDist+1});
				}
			}
		}
		return -1;

	}




}

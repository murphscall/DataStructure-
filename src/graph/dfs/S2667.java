package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2667 {

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N ;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		// 입력 받아 map 채우기
		for(int i = 0; i < N; i++){
			String line = br.readLine();
			for (int j = 0; j < N ; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		List<Integer> houseCount = new ArrayList<>();
		int complexCount = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1 && !visited[i][j]){
					complexCount++;
					houseCount.add(dfs(i,j));
				}
			}
		}

		Collections.sort(houseCount);
		System.out.println(complexCount);
		for (int count : houseCount){
			System.out.println(count);
		}

	}

	static int dfs(int currentX ,  int currentY)  {
		visited[currentX][currentY] = true;
		int count = 1;

		for(int i = 0; i < 4; i++){
			int nextX = currentX + dx[i];
			int nextY = currentY + dy[i];

			if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length ){
				continue;
			}

			if(!visited[nextX][nextY] && map[nextX][nextY] == 1){
				count += dfs(nextX, nextY);
			}
		}

		return count;

	}


}

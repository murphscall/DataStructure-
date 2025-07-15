package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS5 {
	public static void main(String[] args) {
		int N = 5;
		int K = 17;
		boolean[] visited = new boolean[100001];
		visited[N] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{N , 0});


		while(!queue.isEmpty()){
			int[] now = queue.poll();
			int currentPos = now[0];
			int currentTime = now[1];
			int[] currentArray = new int[]{currentPos -1 , currentPos +1 , currentPos *2};

			if(currentPos == K){
				System.out.println(currentTime);
				break;
			}

			for(int i = 0; i < currentArray.length; i++){
				int nextPos = currentArray[i];
				if(nextPos >= 0 && nextPos <= 100000 && visited[nextPos] == false){
					visited[nextPos] = true;
					queue.add(new int[]{nextPos , currentTime+1});
				}
			}
		}
	}


}

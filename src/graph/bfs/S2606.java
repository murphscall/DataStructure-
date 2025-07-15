package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2606 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i<=N ; i++){
			graph.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v= Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		visited[1] = true;
		queue.add(1);

		int infectedCount = 0;

		while(!queue.isEmpty()){
			int now = queue.poll();

			for(int next : graph.get(now)){
				if(visited[next] == false){
					visited[next] = true;
					queue.add(next);
					infectedCount++;
				}
			}
		}
		System.out.println(infectedCount);
	}
}

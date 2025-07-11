package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS {

	static List<List<Integer>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count  = 0;

		graph = new ArrayList<>();
		visited = new boolean[N+1];

		for (int i = 0; i<=N; i++){
			graph.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for(int i = 1; i <= N; i++){
			if(!visited[i]){
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	public static void dfs(int node){
		visited[node] = true;

		for(int neighbor : graph.get(node)){
			if(!visited[neighbor]){
				dfs(neighbor);
			}
		}
	}



}

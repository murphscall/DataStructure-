package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수
		int K = Integer.parseInt(st.nextToken()); // 최단거리
		int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
		}

		int[] distance = new int[N+1];
		Arrays.fill(distance, -1);

		Queue<Integer> queue = new LinkedList<>(); // 큐에는 도시 번호만 저장
		queue.add(X); // 시작 도시 X를 큐에 추가
		distance[X] = 0;

		// distance[] = {-1,0,1,2,-1,-1}
		// queue = {2}
		//          0    1     2     3     4    5
		// graph = {{},{2,3},{4},{4},{}}
		while(!queue.isEmpty()){
			int now = queue.poll();
			// 2

			// 1,3
			for(int next : graph.get(now)){
				if(distance[next] == -1){
					distance[next] = distance[now] + 1;
					queue.add(next);
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <=N; i++){
			if(distance[i] == K){
				result.add(i);
			}
		}

		if(result.isEmpty()){
			System.out.println(-1);
		}else{
			Collections.sort(result);
			for(int city : result){
				System.out.println(city);
			}
		}

	}

}

// 너비 우선 탐색
// 가중치가 없는 그래프에서 최단 경로나 최소 이동 횟수를 구하는 문제에 최적화된 알고리즘
// graph.bfs.BFS 큐(Queue) 자료구조를 이용해서 동작

package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijksta2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		List<HashMap<Integer,Integer>> graph = new ArrayList<>();

		for (int i=0; i <= N; i++){
			graph.add(new HashMap<>());
		}



		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());

			graph.get(X).put(Y,Z);
		}

		int[] distance = new int[N+1];
		Arrays.fill(distance , Integer.MAX_VALUE);

		distance[C] = 0;

		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
		priorityQueue.add(new int[]{0,C});

		while(!priorityQueue.isEmpty()){

			int[] now = priorityQueue.poll();
			int currentCost = now[0];
			int currentCity = now[1];

			if (currentCost > distance[currentCity]) {
				continue;
			}

			for (HashMap.Entry<Integer,Integer> entry : graph.get(currentCity).entrySet()){
				int neighborCity = entry.getKey();
				int neighborCost = entry.getValue();

				int newCost = currentCost + neighborCost;

				if(newCost < distance[neighborCity]){
					distance[neighborCity] = newCost;
					priorityQueue.add(new int[]{newCost,neighborCity});
				}

			}


		}

		int reachableCities = 0;
		int maxTime = 0;

		for (int i = 1; i <= N; i++) {
			// 도달 가능한 도시인 경우
			if (distance[i] != Integer.MAX_VALUE) {
				// 자기 자신(출발 도시)은 제외하고 카운트
				if (i != C) {
					reachableCities++;
					// 가장 오래 걸리는 시간을 찾기 위해 max 값을 갱신
					maxTime = Math.max(maxTime, distance[i]);
				}
			}
		}


		System.out.println(reachableCities + " " + maxTime);

	}
}

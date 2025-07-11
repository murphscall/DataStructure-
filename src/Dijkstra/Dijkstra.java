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
import java.util.SortedSet;
import java.util.StringTokenizer;

public class Dijkstra {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<HashMap<Integer,Integer>> graph = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		for (int i=0; i <= N; i++){
			graph.add(new HashMap<>());
		}

		StringTokenizer st ;
		for(int i = 0 ; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int startCity = Integer.parseInt(st.nextToken());
			int arriveCity = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());

			// 동일한 경로에 다른 비용이 들어올 경우, 더 저렴한 비용으로 저장
			if (!graph.get(startCity).containsKey(arriveCity) || money < graph.get(startCity).get(arriveCity)) {
				graph.get(startCity).put(arriveCity, money);
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;



		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		priorityQueue.add(new int[]{0 , start});


		while(!priorityQueue.isEmpty()){
			int[] now = priorityQueue.poll();
			int currentCost = now[0];
			int currentCity = now[1];

			// 1. 최적화: 이미 더 짧은 경로를 안다면, 이 경로는 무시
			if (currentCost > distance[currentCity]) {
				continue;
			}

			for (HashMap.Entry<Integer,Integer> entry : graph.get(currentCity).entrySet()){
				int neighborCity = entry.getKey();
				int costToNeighbor = entry.getValue();

				int newCost = currentCost + costToNeighbor;

				if(newCost < distance[neighborCity]){
					distance[neighborCity] = newCost;
					priorityQueue.add(new int[]{newCost, neighborCity});
				}
			}


		}


		// 최종 결과 출력
		System.out.println(distance[end]);
	}
}

package graph.bfs;

import java.util.Arrays;

public class BFS2 {

	public static void main(String[] args) {
		int N = 3;
		int[][] computers = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
		boolean[] visited = new boolean[N];
		Arrays.fill(visited,false);
		int networkCount = 0;

		for(int i =0; i < N; i++){
			if(visited[i] == false){
				dfs(i , visited , computers);
				networkCount++;

			}
		}

		System.out.println(networkCount);
	}

	static void dfs(int number , boolean[] visited , int[][] computers){
		visited[number] = true;
			for(int j = 0; j < computers.length; j++){
				if(computers[number][j] == 1 && visited[j] == false){
					dfs(j , visited, computers);
				}
			}
	}
}

// n 개의 컴퓨터
// 각 컴퓨터는 0부터 n-1 까지의 번호
// i번 컴퓨터와 j 번 컴퓨터가 연결되어 있으면 1
// 그렇지 않으면 0 으로 표시 되는
// 2차원 배열 computers[i][j] 가 주어진다.


// 입력 = 컴퓨터 갯수 N 과 computers[i][j] 배열

// 출력 = 네트워크 개수
// 여기서 네트워크란 => 컴퓨터들이 직간접적으로 연결되어 있는 하나의 묶음
// ex ) 연결되어있는 1그룹 , 연결되어있는 2그룹
// A-B, B-C가 연결되어 있다면 A, B, C는 모두 하나의 네트워크에 속함  => 네트워크 1개


// 접근 방법 및 시뮬레이션
// computers[i][j] = 1 이라는 건 i번째 컴퓨터가 j번째 컴퓨터와 연결되었다는 뜻.
// 방문 하지 않은 컴퓨터면 방문 할수있는지 부터확인하고 방문표시?
// 방문 기록 표시는 어떻게?
// 배열의 boolean? 아니면 Map 으로 ?

// 자료구조 및 알고리즘
// 모든 컴퓨터를 방문하려면 완전탐색?

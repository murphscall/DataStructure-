package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS4 {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

		int result = solution(begin , target , words);
		System.out.println(result);


	}

	static int solution(String begin , String target , String[] words){
		int count = 0;
		for (int i = 0; i < words.length ; i++) {
			if(target.equals(words[i])){
				count++;
			}
		}
		if(count == 0){
			return 0;
		}

		boolean[] visited = new boolean[words.length];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(begin,0));

		while(!queue.isEmpty()){
			Node nowNode = queue.poll();
			String currentWord = nowNode.word;
			int currentSteps = nowNode.steps;

			if(currentWord.equals(target)){
				return currentSteps;
			}

			for(int i = 0 ; i< words.length; i++){
				if(visited[i] == false && wordTest(currentWord,words[i])){
					visited[i] = true;
					queue.add(new Node(words[i],currentSteps + 1));

				}
			}
		}
		return 0;
	}

	static boolean wordTest(String currentWord , String loopWord){
		int count  = 0;


		for(int i = 0 ;  i < currentWord.length(); i++){
			if(currentWord.charAt(i) != loopWord.charAt(i)){
				count++;
			}
		}
		return count == 1 ;
	}
}

class Node {
	String word;
	int steps;

	public Node(String word , int steps){
		this.steps =steps;
		this.word = word;
	}
}

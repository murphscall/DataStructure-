package graph.dfs;

public class DFS2 {

	static int answer = 0;
	static int[] numbers = new int[]{1,1,1,1,1};
	static int target = 3;

	public static void main(String[] args) {



		dfs(0,0);




	}

	static void dfs(int index , int sum){

		if(index == numbers.length){
			if(sum == target){
				answer++;
			}
			return;
		}
		dfs(index  + 1 , sum + numbers[index]);
		dfs(index  + 1 , sum - numbers[index]);
	}

}

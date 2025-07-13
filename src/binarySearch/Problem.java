package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {
	public static void main(String[] args) {
	int[] answers = new int[]{1,2,3,4,5};
	int[] pattern1 = new int[]{1,2,3,4,5};
	int[] pattern2 = new int[]{2,1,2,3,2,4,2,5};
	int[] pattern3 = new int[]{3,3,1,1,2,2,4,4,5,5};
	int[] scores = new int[3];

	int[] result = solution(answers,pattern1,pattern2,pattern3,scores);
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] answers, int[] pattern1, int[] pattern2, int[] pattern3 , int[] scores){

		for(int i =0; i < answers.length; i++){
			int answer = answers[i];
			if(pattern1[i%pattern1.length] == answer){
				scores[0] += 1;
			}
			if(pattern2[i%pattern2.length] == answer){
				scores[1] += 1;
			}
			if(pattern3[i%pattern3.length] == answer){
				scores[2] += 1;
			}
		}

		int maxScore = Math.max(scores[0] , Math.max(scores[1],scores[2]));

		List<Integer> winners = new ArrayList<>();

		if(scores[0] == maxScore) {winners.add(1);}
		if(scores[1] == maxScore) {winners.add(2);}
		if(scores[2] == maxScore) {winners.add(3);}


		return winners.stream().mapToInt(i -> i).toArray();
	}
}

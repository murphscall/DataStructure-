package twoPointer;

import java.io.IOException;
import java.util.Arrays;

public class Boat {

	public static void main(String[] args) throws IOException {
		int[] people = new int[]{70,50,80,50};
		int limit = 100;


		int result  = solution(people,limit);
		System.out.println(result);


	}

	public static int solution(int[] people , int limit){
		Arrays.sort(people);
		int boatCount = 0;
		int start = 0;
		int end = people.length - 1;


		while(start <= end){
			int checkWeight = people[start] + people[end];

			if(checkWeight <= limit){
				start ++;
				end --;
			}else {
				end --;
			}
			boatCount++;
		}

		return boatCount;

	}
}

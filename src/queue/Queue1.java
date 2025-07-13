package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queue1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] progresses = br.readLine().split(" ");
		String[] speeds = br.readLine().split(" ");
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = process(queue,progresses,speeds);
		System.out.println(list);

	}

	static List<Integer> process(Queue<Integer> queue,String[] progresses , String[] speeds){


		for(int i = 0; i <progresses.length; i++){
			int progressTime = 100 - Integer.parseInt(progresses[i]);
			int speedTime =  Integer.parseInt(speeds[i]);
			int finalTime =(int) Math.ceil((double) progressTime/speedTime);
			queue.add(finalTime);
		}

		List<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()){
			int time = queue.peek();
			int count = 0 ;


			while (!queue.isEmpty() && queue.peek() <= time) {
				queue.poll(); // 꺼내며 제거
				count++;
			}
			result.add(count);
		}
		return result;


	}
}

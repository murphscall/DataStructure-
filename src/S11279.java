import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class S11279 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		while(N --  > 0) {
			long num = Integer.parseInt(br.readLine());
			if(num > 0 ){
				pq.offer(num);
			}else if(num == 0){
				if(pq.isEmpty()){
					sb.append("0").append("\n");
					continue;
				}
				sb.append(pq.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}

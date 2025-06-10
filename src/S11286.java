import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S11286 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) return a[0] - b[0]; // 절댓값 비교
			return a[1] - b[1];                   // 실제값 비교
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		while(N --  > 0) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0 ){
				pq.offer(new int[]{Math.abs(num) , num});
			}else{
				if(pq.isEmpty()){
					sb.append("0").append("\n");
					continue;
				}
				sb.append(pq.poll()[1]).append("\n");
			}
		}
		System.out.println(sb);
	}
}

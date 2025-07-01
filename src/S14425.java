import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int count = 0;
		Map<String , Integer> map = new HashMap<>();

		for(int i = 0; i < N; i++){
			map.put(br.readLine(), 0);
		}
		for (int i =0; i < M; i++){
			String testStr = br.readLine();
			if(map.containsKey(testStr)){
				count++;
			}
		}
		System.out.println(count);
	}
}

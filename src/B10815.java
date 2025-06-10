import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B10815 {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	Set<Integer> map = new HashSet<>();
	StringTokenizer stk =new StringTokenizer(br.readLine());
	StringBuilder sb = new StringBuilder();
	for (int i=0; i < N; i++){
		map.add(Integer.parseInt(stk.nextToken()));
	};


	int M = Integer.parseInt(br.readLine());
	stk = new StringTokenizer(br.readLine());

	for(int i =0; i< M ; i++) {
		int num = Integer.parseInt(stk.nextToken());
		sb.append(map.contains(num) ? 1:0).append(" ");
	}

		System.out.println(sb);

	}
}

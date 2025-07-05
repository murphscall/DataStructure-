import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2798 {
	public static void main(String[] args) throws IOException {
		int max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cards =  new int[N];
		String[] strCards = br.readLine().split(" ");
		for(int i =0; i < N; i++){
			cards[i] = Integer.parseInt(strCards[i]);
		}




		for(int i=0; i< N -1; i++){
			for(int j = i+1; j < N; j++){
				for(int k = j+1; k <N; k++){
					int sum = cards[i] + cards[j] + cards[k];
					if(sum <= M && sum > max){
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}

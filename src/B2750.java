import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i =0; i< arr.length - 1; i++){
			for(int j = 0 ; j< arr.length -1 - i; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println("정렬된 배열");
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoPointer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrLength = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] arr = new int[strArr.length];
		for(int i = 0; i < strArr.length; i++){
			arr[i] = Integer.parseInt(strArr[i]);
 		}
		int M = Integer.parseInt(br.readLine());
		int count = 0;
		int start = 0;
		int end = arrLength -1;

		while(true){

			if(start >= end){
				break;
			}

			int sum = arr[start] + arr[end];


			if(sum == M){
				start++;
				end--;
				count++;
			}else if(sum > M){
				end--;
			}else{
				start++;
			}
		}
		System.out.println(count);

	}
}

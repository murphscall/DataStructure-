import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4779 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null && !line.isEmpty()){
			int N = Integer.parseInt(line);
			int strLength = (int) Math.pow(3,N);
			char[] str = new char[strLength];

			for (int i = 0; i<strLength; i++){
				str[i] = '-';
			}

			divideThirds(str , 0 , strLength);
			System.out.println(new String(str));

		}
	}

	static void divideThirds(char[] arr ,int start ,int size){
		if(size == 1) {
			return;
		}
		int newSize = size / 3;

		for(int i = start + newSize; i < start + 2* newSize; i++){
			arr[i] =' ';
		}

		divideThirds(arr , start, newSize);
		divideThirds(arr , start + newSize * 2 , newSize);
	}
}

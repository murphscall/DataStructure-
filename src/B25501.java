import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B25501 {

	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < N;  i++){
			String isPalindromeStr = br.readLine();
			System.out.println(isPalindrome(isPalindromeStr) +" "+ count);
		}

	}

	public static int recursion(String str, int l , int r){
		count++;
		if(l >= r) return 1;
		else if(str.charAt(l) != str.charAt(r)){
			return 0;
		}
		else{
			return recursion(str , l + 1 , r -1);
		}
	}

	public static int isPalindrome(String str){
		count = 0;
		return recursion(str , 0 , str.length()-1);
	}
}

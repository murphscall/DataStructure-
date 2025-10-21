import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2743 {
	public static void main(String[] args) throws IOException {
		// 입력 : 알파벳으로만 이루어진 단어를 입력받는다.
		// 단어의 길이는 최대 100 이며 영어 소문자와 대문자로만 이루어져있다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		System.out.println(str.length());
	}
}

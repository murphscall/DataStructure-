import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2745 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 진법 수 N
        long result = Long.parseLong(st.nextToken(), Integer.parseInt(st.nextToken()));

        System.out.println(result);
    }
}

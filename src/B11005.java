import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        if(N == 0){
            System.out.println(0);
            return;
        }

        while(N > 0) {
            int remainder = (int) N % B;
            sb.append(digits[remainder]);
            N /= B;
        }

        System.out.println(sb.reverse().toString());
    }
}

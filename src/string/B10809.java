package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10809 {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alphabet.length(); i++) {
            int idx = str.indexOf(alphabet.charAt(i));
            if (idx == -1) {
                sb.append(-1);
            } else {
                sb.append(idx);
            }

            if (i < alphabet.length() - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);

    }
}

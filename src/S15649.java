import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S15649 {
    static int N, M;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[M];

        backtracking(0);

     }

    static void backtracking(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(result[i]+ " ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= N; i++){
            if (!visited[i]){
                visited[i] = true;
                result[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

}

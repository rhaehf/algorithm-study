import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            // 빈칸 채우기
            for (int j = 0; j < N - i; j++) {
                sb.append(" ");
            }
            // 별 채우기
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n"); // 다음줄 띄어쓰기
        }
        System.out.println(sb);
    }
}

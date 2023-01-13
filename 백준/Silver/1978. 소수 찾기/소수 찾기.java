import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int result = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != 1) {
                result += isPrime(num);
            }
        }
        System.out.println(result);
    }

    private static int isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
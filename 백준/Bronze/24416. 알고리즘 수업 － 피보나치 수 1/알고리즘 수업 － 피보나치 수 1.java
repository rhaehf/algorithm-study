import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        f = new int[n];

        fib(n);
        fibonacci(n);
        System.out.println(count1 + " " + count2);
    }

    private static int fibonacci(int n) {
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n; i++) {
            count2++;
            f[i] = f[i-2] + f[i-1];
        }
        return f[n-1];
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            count1 += 1;
            return 1;
        } else return (fib(n - 1) + fib(n - 2));
    }
}
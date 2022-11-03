//package P2739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder st = new StringBuilder();

        if (n >= 1 && n <= 9) {
            for (int i = 1; i <= 9; i++) {
                st.append(n + " * " + i + " = " + n*i + "\n");
            }
        }
        System.out.println(st);
    }
}

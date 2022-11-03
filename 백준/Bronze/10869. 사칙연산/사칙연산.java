//package P10869;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/P10869/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if(1 <= a && b <= 10000){
            int plus = a + b;
            int minus = a - b;
            int multiply = a * b;
            int divide = a / b;
            int mod = a % b;

            sb.append(plus + "\n" + minus + "\n" + multiply + "\n" + divide + "\n" + mod);
        }
        System.out.println(sb);
    }
}

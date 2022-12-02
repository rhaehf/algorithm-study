//package P8958;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int countO = 0;
            int sum = 0;
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < input.length; j++) {
                if (input[j] == 'O') {
                    countO += 1;
                    sum += countO;
                } else {
                    countO = 0;
                }
            }
            System.out.println(sum);
        }
    }
}

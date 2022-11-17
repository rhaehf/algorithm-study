//package P11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numberLine = br.readLine();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Character.getNumericValue(numberLine.charAt(i));
            sum += num;
        }
        System.out.println(sum);
    }
}

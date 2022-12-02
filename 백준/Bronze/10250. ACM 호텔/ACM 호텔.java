//package Class2.P10250;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] nums = br.readLine().split(" ");
            int H = Integer.parseInt(nums[0]);
            int W = Integer.parseInt(nums[1]);
            int N = Integer.parseInt(nums[2]);

            int x = N / H;
            int y = N % H;
            StringBuilder sb = new StringBuilder();
            if (y != 0) {
                sb.append(y);
                if (x + 1 <= 9)
                    sb.append(0);
                sb.append(x + 1);
            } else {
                sb.append(H);
                if (x <= 9)
                    sb.append(0);
                sb.append(x);
            }
            System.out.println(sb);
        }
    }
}

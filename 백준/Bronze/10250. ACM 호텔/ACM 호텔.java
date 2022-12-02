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

            int YY, XX;
            int ho = N / H;
            int floor = N % H;
            if (floor != 0) {
                YY = floor;
                XX = ho + 1;
            } else {
                YY = H;
                XX = ho;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(YY);
            if (XX <= 9) {
                sb.append(0).append(XX);
            } else {
                sb.append(XX);
            }
            System.out.println(sb);
        }
    }
}

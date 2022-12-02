//package P4153;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);

            if (a == 0 && b == 0 && c == 0)
                break;

            if ((a * a + b * b) == c * c) {
                System.out.println("right");
            } else if ((a * a + c * c) == b * b) {
                System.out.println("right");
            } else if ((b * b + c * c) == a * a) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}

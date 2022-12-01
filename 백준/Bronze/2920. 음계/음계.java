//package P2920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[8];
        for (int i = 0; i < 7; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean asc = false;
        boolean dsc = false;
        boolean mix = false;

        for (int i = 0; i < 6; i++) {
            int result = nums[i + 1] - nums[i];
            if (result == 1) {
                asc = true;
            } else if (result == -1) {
                dsc = true;
            } else {
                mix = true;
            }
        }

        if (mix) {
            System.out.println("mixed");
        } else if (asc) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}

//package P2562;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/P2562/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int max = Integer.parseInt(st.nextToken());
        int index = 1;
        for (int i = 2; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            if(number > max){
                max = number;
                index = i;
            }
        }

        sb.append(max).append("\n").append(index);
        System.out.println(sb);
    }
}

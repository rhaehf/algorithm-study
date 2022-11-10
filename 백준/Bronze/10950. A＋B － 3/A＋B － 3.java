//package P10950;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("src/P10950/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String oneLine = br.readLine();
            String[] lineArray = oneLine.split(" ");

            int a = Integer.parseInt(lineArray[0]);
            int b = Integer.parseInt(lineArray[1]);

            System.out.println(a + b);

        }
    }
}

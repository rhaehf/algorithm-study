//package P10952;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("src/P10952/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while((line = br.readLine()).charAt(0) - '0' != 0){
            int a = line.charAt(0) - '0'; // '0'(문자 0)의 아스키코드는 48
            int b = line.charAt(2) - '0';

            sb.append( a + b).append("\n");
        }
        System.out.println(sb);
    }
}

//package P11654;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/P11654/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = br.readLine();
        char toChar = read.charAt(0);
        int toInt = (int) toChar;
        System.out.println(toInt);
    }
}

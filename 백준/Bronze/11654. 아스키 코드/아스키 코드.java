//package P11654;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = br.readLine();
        char toChar = read.charAt(0);
        int toInt = toChar;
        System.out.println(toInt);
    }
}

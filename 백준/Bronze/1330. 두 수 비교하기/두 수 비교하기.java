//package P1330;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a,b;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/P1330/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a > b){
            System.out.println(">");
        }
        else if(a < b){
            System.out.println("<");
        }
        else{
            System.out.println("==");
        }
    }
}

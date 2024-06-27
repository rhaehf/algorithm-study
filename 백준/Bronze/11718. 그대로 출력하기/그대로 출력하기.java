import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while(input != null && !input.isEmpty()) {
            System.out.println(input);
            input = br.readLine();  // 루프 내부에서 입력을 갱신
        }
    }
}
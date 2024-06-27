import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        char[] tmp1 = st.nextToken().toCharArray();
        char[] tmp2 = st.nextToken().toCharArray();

        for (int i = 2; i >= 0; i--) {
            if(tmp1[i] > tmp2[i]){
                System.out.print(tmp1[2]);
                System.out.print(tmp1[1]);
                System.out.print(tmp1[0]);
                break;
            }
            else if(tmp1[i] == tmp2[i]){
                continue;
            }
            else if (tmp1[i] < tmp2[i]){
                System.out.print(tmp2[2]);
                System.out.print(tmp2[1]);
                System.out.print(tmp2[0]);
                break;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        
        // N개의 boolean 원소를 갖는 배열을 선언해야 했지만,
        // 비트마스크를 이용하면 정수 하나로 표현이 가능하다.
        int set = 0; // 비트마스크를 이용한 집합 구현 
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) { 
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num = -1; // 하나의 원소 = 하나의 비트를 의미

            switch (command) { // 비트 연산
                case "add": // 추가
                    num = Integer.parseInt(st.nextToken());
                    set = set | (1 << num);
                    break;
                case "remove": // 제거
                    num = Integer.parseInt(st.nextToken());
                    set = set & ~(1 << num);
                    break;
                case "check": // 포함 여부 확인 : 특정 원소가 포함되어 있는지 확인
                    num = Integer.parseInt(st.nextToken());
                    if ((set & (1 << num)) > 0)
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "toggle": // 토글 : 원소가 빠져있는 경우에는 추가하고, 들어있는 경우에는 삭제
                    num = Integer.parseInt(st.nextToken());
                    set = set ^ (1 << num);
                    break;
                case "all": // 1 ~ 20으로 바꾸기
                    set = (1 << 21) - 1;
                    break;
                case "empty": // 비우기
                    set = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}

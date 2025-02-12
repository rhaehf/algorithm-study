import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arrayN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         arrayN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrayN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrayN); // 이분 탐색을 사용하기 위해서 정렬하기

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int key) {
        int low = 0; // 탐색 범위의 왼쪽 끝 인덱스
        int high = arrayN.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스

        // low가 high보다 커지기 전까지 반복.
        while(low <= high) {
            int mid = (low + high) / 2;	// 중간위치를 구한다.

            // key 값이 중간 위치의 값보다 작을 경우
            if(key < arrayN[mid]) {
                high = mid - 1;
            }
            // key 값이 중간 위치의 값보다 클 경우
            else if(key > arrayN[mid]) {
                low = mid + 1;
            }
            // key 값과 중간 위치의 값이 같을 경우
            else {
                return mid;
            }
        }

        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;
    }
}

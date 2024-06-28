import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken()); // 상근이의 카드
        }
        Arrays.sort(nArr); // 이진 탐색을 위해서 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int compare = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(nArr, N, compare) + " ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] nArr, int N, int compare) { // 이진 탐색
        int start = 0;
        int end = N - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (nArr[mid] == compare) { // 중간 값이 찾는 값이라면 1 반환
                return 1;
            }

            if (nArr[mid] < compare) { // 찾는 값이 배열의 중간 값보다 크면 
                start = mid + 1; // 시작 지점을 +1 해서 범위 줄이기
            } else { // 찾는 값이 배열의 중간 값보다 작으면 
                end = mid - 1; // 끝 지점을 -1해서 범위 줄이기
            }
        }
        return 0;
    }
}
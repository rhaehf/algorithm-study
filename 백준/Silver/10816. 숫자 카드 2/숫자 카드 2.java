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
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken()); // 찾아야 하는 수
//            int count = binarySearch(target);
            int count = upperBound(target) - lowerBound(target);
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    // lower_bound: target이 처음 등장하는 위치 찾기
    public static int lowerBound(int target) {
        int low = 0;
        int high = arrayN.length;

        // low와 high가 같아질 때 까지 반복
        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= arrayN[mid]) {
                // 처음 등장하는 위치를 찾는 것은 같은 값이 있는 요소들의 가장 왼쪽을 찾아내야하기 때문에
                // 왼쪽으로 범위를 좁히기 위해선 high 값을 mid로 사용함으로써 범위를 줄인다.(= 상한선을 내린다.)
                high = mid;
            } else {
                // 반대로 오른쪽으로 범위를 좁혀나가야 하기 때문에
                // low 값을 mid 보다 크게해서 하한선을 올린다.
                low = mid + 1;
            }
        }
        return low;
    }

    // upper_bound: target을 초과하는 첫 번째 위치 찾기
    public static int upperBound(int target) {
        int low = 0;
        int high = arrayN.length;

        // low와 high가 같아질 때 까지 반복
        while (low < high) {
            int mid = (low + high) / 2;
            if (target < arrayN[mid]) {
                // 상한선을 내린다.
                high = mid;
            } else {
                // 하한선을 올린다.
                low = mid + 1;
            }
        }
        return low;
    }
}

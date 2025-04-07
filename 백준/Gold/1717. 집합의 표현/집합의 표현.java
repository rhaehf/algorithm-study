import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집합의 개수
        int m = Integer.parseInt(st.nextToken()); // 경우의 수

        parent = new int[n + 1]; // 문제에서 n+1개의 집합을 이루고 있음
        depth = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // 초기화 : i 원소에 대한 부모 노드 번호를 저장
            parent[i] = i;
            depth[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 0이면 합집합
            if (command == 0) {
                union2(a, b);
            } else if (command == 1) {
                // 1이면 두 원소 a,b가 같은 집합에 포함되어 있는지 확인하는 연산 : 부모가 같으면 같은 집합에 포함된 것
                sb.append((find(a) == find(b) ? "YES" : "NO") + "\n");
            }
        }
        System.out.println(sb);
    }

    // find 연산 : 원소가 속한 집합(집합의 대표 번호)을 반환
    public static int find(int x) {
        // 부모를 루트로 만들어주면서 깊이를 줄이는 최적화 과정
//        return parent[x] == x ? x : (parent[x] = find(parent[x]));

        if (parent[x] == x) // 자신이 루트 노드인 경우
            return parent[x]; // 그대로 반환
        else
            return parent[x] = find(parent[x]); // 루트 찾으며 경로 압축
    }

    // union 연산 : 각 원소가 속한 집합을 하나로 합치는 연산
    // 더 작은 쪽을 큰 쪽의 부모로 설정하여 하나의 집합으로 묶는다.
    static void union1(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);

        if (b < a) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    // 기본 union 연산에 트리의 깊이(depth)까지 고려한 방법이다.
    public static void union2(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            // 깊이가 더 낮은 트리를 깊이가 더 높은 트리 아래로 붙이기 위해
            // x와 y를 교환하여 "x가 항상 더 깊은 트리의 루트가 되도록 함"
            if (depth[x] < depth[y]) {
                // 즉, x가 더 깊은 쪽이 되도록 x와 y를 바꾸고
                // y(얕은 트리)를 x(깊은 트리) 아래에 붙이게 된다
                int tmp = x;
                x = y;
                y = tmp;

                // 이렇게 하면 항상 얕은 트리가 깊은 트리 아래에 붙게 되어
                // 전체 트리의 높이 증가를 최소화할 수 있다
            }

            // 부모 값이 작은 노드를 부모 값이 큰 쪽으로 옮기는 작업, 부모를 옮기면 두 트리가 합쳐짐
            // 이제 x가 더 깊거나 같음, 깊이가 더 높은 쪽(x)이 부모가 됨
            parent[y] = x; // 얕은 y를 깊은 x 밑으로 붙이는 구조

            // 두 트리의 깊이가 같으면, 붙이고 나서 깊이 1 증가
            if (depth[x] == depth[y]) depth[x]++;
        }
    }
}

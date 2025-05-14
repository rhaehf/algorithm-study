import java.util.*;

class Solution {
    static int[] distance; // 인덱스 번호를 노드 번호라고 했을 때 1번 노드까지의 거리 
    static boolean[] visited; // 방문 체크
    static List<List<Integer>> graph = new ArrayList<>(); // 인접 리스트 그래프 - 노드의 연결된 정보 저장
    static Queue<Integer> bfs = new LinkedList<>(); // BFS 큐
    
    public int solution(int n, int[][] edge) {
        // 인덱스 0번은 사용하지 않음
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        
        // 리스트 안에 리스트로 구성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // graph의 각 인덱스 번호를 노드 번호라고 하고, 노드 번호와 연결된 다른 노드 번호 넣기
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            // 양방향 간선 정보 저장
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 테스트 1 : [[], [3, 2], [3, 1, 4, 5], [6, 4, 2, 1], [3, 2], [2], [3]]
        //System.out.println(graph);
        
        bfs.add(1); // 시작 노드 설정
        visited[1] = true; // 방문 처리
        
        // 방문할 노드가 없을 때까지 실행
        while (!bfs.isEmpty()) {
            int nowNode = bfs.poll(); // 탐색할 노드 꺼내기            
            List<Integer> nodeList = graph.get(nowNode);; // 탐색할 노드와 연결된 노드들의 리스트
            
            // 연결된 노드들을 탐색
            for (int next : nodeList) {
                if (!visited[next]) { // 방문 안했다면
                    bfs.add(next); // 다음 탐색 할 노드 추가
                    visited[next] = true; // 방문 처리
                    distance[next] = distance[nowNode] + 1; // 연결된 노드에 탐색할 노드로부터 1을 더해서 거리 갱신
                }      
            }            
        }
        
         // 최대 거리 찾기
        int max = 0, cnt = 0;
        for (int d : distance) {
            if (d > max) {
                max = d;
                cnt = 1;
            } else if (d == max) {
                cnt++;
            }
        }
        
        return cnt;
    }
}

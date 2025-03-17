import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
/*
        // key : 이름, value : 이름이 명단에 출연한 수
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String name : map.keySet()) {
            // 각각의 명단에 이름이 등장하여 출연 횟수가 2인 경우 = 듣도 보도 못한 사람인 경우
            if (map.get(name) == 2) {
                list.add(name);
                count++;
            }
        }
        */

        // 듣도 못한 사람 기록
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, 1); // 듣도 못한 사람은 1로 기록
        }

        // 보도 못한 사람 처리 및 바로 교집합 추출
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) { // 듣도 못한 사람 목록에 있으면
                list.add(name); // 바로 교집합에 추가
            }
        }

        Collections.sort(list); // ArrayList를 오름차순으로 정렬

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb); // 듣도 보도 못한 사람의 수와 명단을 사전순으로 출력
    }
}

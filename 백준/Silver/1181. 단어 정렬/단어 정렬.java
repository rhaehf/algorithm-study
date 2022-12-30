import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    // o1이 o2보다 오른쪽으로 정렬함 -> o2 o1
                    return 1;
                } else if (o1.length() < o2.length()) {
                    // o2가 o1보다 오른쪽으로 정렬함 -> o1 o2
                    return -1;
                } else {
                    // o1, o2의 길이가 같으면 알파벳 순서로 정렬
                    return o1.compareTo(o2);
                }
            }
        });

        for (String word : list) {
            System.out.println(word);
        }
    }
}
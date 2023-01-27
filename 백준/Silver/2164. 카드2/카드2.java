import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> numQ = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            numQ.add(i + 1);
        }

        while (numQ.size() != 1) {
            numQ.poll();
            int peekNum = numQ.peek();
            numQ.poll();
            numQ.add(peekNum);
        }
        System.out.println(numQ.peek());
    }
}
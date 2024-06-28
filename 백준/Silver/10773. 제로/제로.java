import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K ; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n !=0 ){
                stack.push(n);    
            } else {
                stack.pop();
            }            
        }
        
        int count = 0;
        for(int j = 0; j < stack.size(); j++){
            count += stack.elementAt(j);
        }
        System.out.println(count);
    }
}
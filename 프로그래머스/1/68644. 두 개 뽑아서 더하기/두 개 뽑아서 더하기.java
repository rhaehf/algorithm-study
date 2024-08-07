import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {

        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i=0; i < numbers.length-1; i++){
            for (int j = i + 1; j < numbers.length; j++) {
                ts.add(numbers[i] + numbers[j]);
            }
        }
        
        // new Integer[0]은 TreeSet의 크기에 맞는 배열이 자동으로 생성된다.
        // Integer[] array = ts.toArray(new Integer[0]);
        // return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        return ts.stream().mapToInt(Integer::intValue).toArray();
    }
}
import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {

        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i=0; i < numbers.length-1; i++){
            for (int j = i + 1; j < numbers.length; j++) {
                ts.add(numbers[i] + numbers[j]);
            }
        }
        
        Integer[] array = ts.toArray(new Integer[0]);
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}
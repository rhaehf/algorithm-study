import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int count = -1;
        
        while (true) {
            //System.out.println("1번 arr (이번 턴에 사용됨) : " + Arrays.toString(arr));
            int[] copy = Arrays.copyOf(arr, arr.length);
            count++;
            //System.out.println("1번 copy (1번 arr를 1번 copy로 복사 해줌) : " + Arrays.toString(copy));

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                }
            }

            //System.out.println("2번 arr (계산 결과) : " + Arrays.toString(arr));
            //System.out.println("2번 copy (2번 arr와 비교할 값) : " + Arrays.toString(copy));
            //System.out.println("----------");

            if (Arrays.equals(copy, arr))
                break;
        }

        return count;
    }
}
import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        // 방법 1 - 배열을 오름차순해서 풀기
        int[] nums = {a, b, c, d};
        Arrays.sort(nums); //오름차순 정렬

        //모두 같은 경우
        if (nums[0] == nums[3]) {
            return 1111 * nums[0];
        }
        //세 주사위가 같은 경우
        else if (nums[0] == nums[2]) {
            return (int) Math.pow((10 * nums[0] + nums[3]), 2);
        } else if (nums[1] == nums[3]) {
            return (int) Math.pow((10 * nums[1] + nums[0]), 2);
        }
        //두 개씩 같을 경우 
        else if (nums[0] == nums[1] && nums[2] == nums[3]) {
            return (nums[0] + nums[2]) * Math.abs(nums[0] - nums[2]);
        }
        //두 개만 같고, 나머지는 각각 다를 경우 
        else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[3]) {
            if (nums[0] == nums[1]) {
                return nums[2] * nums[3];
            } else if (nums[1] == nums[2]) {
                return nums[0] * nums[3];
            } else {
                return nums[0] * nums[1];
            }
        }
        //모두 다른 경우 
        else {
            return nums[0];
        }
        
        /* - 내가 풀던 방법
        int[] array = {a, b, c, d};
        List<Integer> list = Arrays.stream(array) // `IntStream` 생성
                                   .boxed() // `int` → `Integer` 변환 (Auto-boxing)
                                   .collect(Collectors.toList()); // 리스트로 변환
        // set 자료형 - 순서 X, 데이터 중복 X
        HashSet<Integer> set = new HashSet<>(Arrays.asList(a, b, c, d)); //초기값 지정
        // HashSet<Integer> set = new HashSet<>(Set.of(a, b, c, d));
        // HashSet<Integer> set = IntStream.of(array).boxed().collect(Collectors.toSet());

        
        // 조건1 - 모두 같음
        if(a == b && b == c && c == d){
            return 1111 * a;
        }
        // 조건 5 - 모두 다름
        else if(set.size() == 4){
            int min = array[0];
            for(int i=1; i<4; i++){
                min = Math.min(array[i], min);
            }
            return min;            
        }
        // 조건4 - 두 개가 같은 p, 나머진 q, r 
        else if(set.size() == 3){              
        
        } else{
            // 조건2 - 세 개 같은 숫자 p, 하나만 다름 q
            
            // 조건3 - 두 개씩 같음 p, q
            
        } 
        */
    }
}
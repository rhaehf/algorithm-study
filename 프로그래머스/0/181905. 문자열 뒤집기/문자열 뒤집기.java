class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = my_string.substring(0,s);
        
        // 두번째 풀이 - StringBuffer 클래스와 StringBuilder 클래스의 reverse( ) 메서드 사용
        StringBuilder tmp = new StringBuilder(my_string.substring(s, e + 1));        
        return answer + tmp.reverse() + my_string.substring(e+1);
        
        // 첫번째 풀이
        /*
        char[] array = my_string.substring(s,e+1).toCharArray();
        for(int i = array.length - 1; 0 <= i ; i--){
            answer += array[i];
        }
        
        return answer + my_string.substring(e+1);
        */
    }
}
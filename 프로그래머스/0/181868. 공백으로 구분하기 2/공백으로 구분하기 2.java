class Solution {
    public String[] solution(String my_string) {
        // 정규식 "\s"는 다음과 같은 종류의 공백(white space)을 나타낸다. : (\t, \n, \x0B, \f, \r)
        // "+"는 1번이상을 의미한다. 즉, "\s+"는 1번 이상의 공백을 의미한다.
        // trim : 앞, 뒤 공백 제거
        
        return my_string.trim().split("\\s+");
        //return my_string.replaceAll("\\s+", " ").trim().split(" ");
    }
}
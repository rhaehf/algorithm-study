class Solution {
    public String solution(String my_string, String alp) {
        // replace, replaceAll 둘 다 결과는 같지만 replace는 특수 문자로도 치환이 된다.
        return my_string.replace(alp, alp.toUpperCase());
    }
}
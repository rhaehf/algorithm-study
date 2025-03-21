import java.util.*;

class Solution {
    public String solution(String myString, String pat) {
        int index = myString.lastIndexOf(pat) + pat.length() - 1;
        return myString.substring(0, index + 1);
    }
}
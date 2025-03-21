import java.util.*;

class Solution {
    public String solution(String myString, String pat) {
        int lastIndex = myString.lastIndexOf(pat) + pat.length() - 1;
        return myString.substring(0, lastIndex + 1);
    }
}
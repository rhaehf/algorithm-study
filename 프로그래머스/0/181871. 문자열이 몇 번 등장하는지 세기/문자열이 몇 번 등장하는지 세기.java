class Solution {
    public int solution(String myString, String pat) {
        // 두번째 방법 : startsWith - 입력된 문자열로 시작하는지 확인하고 true/false 반환
        int count = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.substring(i).startsWith(pat)) {
                count++;
            }
        }
        return count;
        
        /*
        // 첫번재 방법
        int firstIdx = myString.indexOf(pat);
        
        if(firstIdx == -1)
            return 0;
        
        int lastIdx = myString.lastIndexOf(pat);

        int count = 0;
        for (int i = firstIdx; i <= lastIdx; i++) {
            int end = i + pat.length();
            if (myString.substring(i, end).equals(pat))
                count++;
        }

        return count;
        */
    }
}
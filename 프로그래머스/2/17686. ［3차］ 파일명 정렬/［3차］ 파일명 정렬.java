import java.util.*;

class Solution {
    public String[] solution(String[] files) {        
        List<FileInfo> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i]; // 파일명
            
            int mid = -1; // 숫자 시작 인덱스
            int end = -1; // 숫자 끝나는 인덱스
            
            // 숫자 시작 위치 찾기
            for (int j = 0; j < file.length(); j++) {                
                if (Character.isDigit(file.charAt(j))) {
                    mid = j;
                    break;
                }            
            }
            
            // 숫자 구간 끝 찾기 (최대 5자리)
            end = mid;
            int count = 0;
            while (end < file.length()
                    && Character.isDigit(file.charAt(end))
                    && count < 5) {
                end++;
                count++;
            }
            
            // 파일명 부분 구해서 리스트 만들기            
            String head = file.substring(0, mid);
            int number = Integer.parseInt(file.substring(mid, end));
            list.add(new FileInfo(file, head.toLowerCase(), number, i));
        }
        
        Collections.sort(list, (a, b) -> {
            // 1. HEAD 비교 (사전순)
            int cmp = a.head.compareTo(b.head);
            if (cmp != 0) return cmp;

            // 2. NUMBER 비교 (숫자)
            cmp = Integer.compare(a.number, b.number);
            if (cmp != 0) return cmp;

            // 3. 원래 입력 순서
            return Integer.compare(a.index, b.index);
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).file;
        }
        return answer;
    }
}

class FileInfo {
    String file;   // 원본 파일명
    String head;   // 소문자로 만든 head (정렬용)
    int number;    // number를 int로 변환한 값
    int index;     // 원래 files 배열 인덱스

    FileInfo(String file, String head, int number, int index) {
        this.file = file;
        this.head = head;
        this.number = number;
        this.index = index;
    }
}

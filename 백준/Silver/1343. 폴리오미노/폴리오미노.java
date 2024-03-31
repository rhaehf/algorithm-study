import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
//        System.out.println("line : " + line);
        String[] poly = line.split("");
//        System.out.println("poly : " + Arrays.toString(poly));

//        System.out.println("poly 길이 : " + poly.length);
        if (poly.length == 1) {
            if(poly[0].equals(".")){
                System.out.println(".");
            } else if(poly[0].equals("X")) {
                System.out.println("-1");
            } else{
                System.out.println(poly[0]);
            }
            System.exit(0);
        }

        int countX = 0;

        answer = new String[poly.length];
        Arrays.fill(answer, "c");

        for (int i = 0; i < poly.length; i++) {
            if (poly[i].equals("X")) {
                countX += 1;
            } else { // if(poly[i].equals("."))
//                System.out.println("countX : " + countX);

                answer[i] = ".";
//                System.out.println(". 넣기 : " + Arrays.toString(answer));

                replacePoly(countX, i);
                countX = 0;
//                System.out.println("채우기 : " + Arrays.toString(answer));
            }
        }

//        System.out.println("for 끝난 countX : " + countX);
        // .으로 끝나지 않았을 때 바꾸지 못한 부분을 마저 바꿔주기
        if (countX != 0) {
//            System.out.println("replacePoly 한번 더");
            replacePoly(countX, poly.length);
        }
//        System.out.println("makePoly 이후 : " + Arrays.toString(answer));

        // 콘솔에 문자 하나씩 출력
        for(String strValue : answer) {
            System.out.print(strValue);
        }
    }

    public static void replacePoly(int countX, int i) {
        // countX가 홀수면 -1 출력
        if (countX % 4 == 1 || countX % 4 == 3) {
            System.out.println("-1");
            System.exit(0);
        } else {
            // AAAA로 바꿀게 1개 이상 있으면 countX 개수만큼 전부 A로 바꿔주기
            if (countX / 4 >= 1) {
                for (int j = (i - countX); j < i; j++) {
                    answer[j] = "A";
                }
            }

            // BB로 바꿀 부분이 있는지 확인
            if (countX % 4 == 2) {
                answer[i - 1] = "B";
                answer[i - 2] = "B";
            }
        }
    }
}
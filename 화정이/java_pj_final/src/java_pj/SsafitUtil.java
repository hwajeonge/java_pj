package java_pj;

import java.util.Scanner;

public class SsafitUtil {
    private Scanner sc;

    // 기본 생성자
    public SsafitUtil() {
        sc = new Scanner(System.in);
    }

    // 메시지를 출력하고 사용자로부터 문자열 입력을 받는 메서드
    public String input(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    // 메시지를 출력하고 사용자로부터 정수 입력을 받는 메서드
    public int inputInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.next(); // 잘못된 입력을 버립니다.
            System.out.print(msg);
        }
        return sc.nextInt();
    }

    // 구분선을 출력하는 메서드 (기본적으로 줄바꿈)
    public void printLine() {
        System.out.println();
    }

    // 지정된 문자로 구분선을 출력하는 메서드
    public void printLine(char ch) {
        for (int i = 0; i < 50; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    // 지정된 문자와 길이로 구분선을 출력하는 메서드
    public void printLine(char ch, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    // 화면을 클리어하는 메서드 (콘솔에서는 주로 줄바꿈으로 처리)
    public void screenClear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
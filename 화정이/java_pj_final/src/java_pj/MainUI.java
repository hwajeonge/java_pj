package java_pj;

import java.util.Scanner;

public class MainUI {
    public void service() {
        while (true) {
            System.out.println("=================================================");
            System.out.println("              자바로 구현하는 SSAFIT              ");
            System.out.println("-------------------------------------------------");
            System.out.println("1. 영상정보");
            System.out.println("2. 회원관리");
            if (SessionManager.getInstance().isLoggedIn()) {
                System.out.println("3. 로그아웃");
            } else {
                System.out.println("3. 로그인");
            }
            System.out.println("0. 종료");
            System.out.println("-------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");

            int menu = inputInt();

            switch (menu) {
                case 1:
                    VideoUi videoUi = VideoUi.getInstance();
                    videoUi.service();
                    break;
                case 2:
                    memberManagementMenu();
                    break;
                case 3:
                    if (SessionManager.getInstance().isLoggedIn()) {
                        SessionManager.getInstance().logout();
                        System.out.println("로그아웃되었습니다.");
                    } else {
                        new LoginUI().service();
                    }
                    break;
                case 0:
                    exit();
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }
    
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    private void memberManagementMenu() {
        // 회원관리 UI 호출
        MemberUI memberUI = new MemberUI();
        memberUI.service();
    }

    private int inputInt() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.next(); // 잘못된 입력을 버립니다.
            System.out.print("메뉴를 선택하세요 : ");
        }
        return sc.nextInt();
    }
}


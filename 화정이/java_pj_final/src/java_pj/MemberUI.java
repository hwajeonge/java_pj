package java_pj;

import java.util.Scanner;

public class MemberUI {
    private MemberDao memberDao = MemberDaoImpl.getInstance();
    private Scanner sc = new Scanner(System.in);

    public void service() {
        while (true) {
            System.out.println("=================================================");
            System.out.println("                 회원 관리 시스템                  ");
            System.out.println("-------------------------------------------------");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원목록 보기");
            System.out.println("0. 종료");
            System.out.println("-------------------------------------------------");
            System.out.print("메뉴를 선택하세요: ");

            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    listMembers();
                    break;
                case 0:
                    memberDao.saveToFile();
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }

    private void registerMember() {
        System.out.print("아이디: ");
        String id = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("비밀번호: ");
        String password = sc.nextLine();
        System.out.print("이메일: ");
        String email = sc.nextLine();

        Member member = new Member(id, name, password, email);
        memberDao.addMember(member);
        System.out.println("회원가입이 완료되었습니다.");
    }

    private void listMembers() {
        System.out.println("=================================================");
        System.out.println("                     회원 목록                     ");
        System.out.println("-------------------------------------------------");

        for (Member member : memberDao.getMembers()) {
            System.out.println(member);
        }
    }
}

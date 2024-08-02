package java_pj;

import java.util.Scanner;

public class LoginUI {
	private MemberDao memberDao = MemberDaoImpl.getInstance();
    private Scanner sc = new Scanner(System.in);

    public void service() {
        System.out.print("아이디: ");
        String id = sc.nextLine();
        System.out.print("비밀번호: ");
        String password = sc.nextLine();

        Member member = memberDao.getMemberById(id);
        if (member != null && member.getPassword().equals(password)) {
            SessionManager.getInstance().login(member);
            System.out.println(member.getName() + "님, 로그인되었습니다.");
        } else {
            System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }

}

package java_pj;

public class SessionManager {
	private static SessionManager instance = new SessionManager();
    private Member loggedInMember;

    private SessionManager() {}

    public static SessionManager getInstance() {
        return instance;
    }

    public void login(Member member) {
        loggedInMember = member;
    }

    public void logout() {
        loggedInMember = null;
    }

    public Member getLoggedInMember() {
        return loggedInMember;
    }

    public boolean isLoggedIn() {
        return loggedInMember != null;
    }

}

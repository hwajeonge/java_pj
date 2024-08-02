package java_pj;

import java.util.List;

public interface MemberDao {
    void addMember(Member member);
    List<Member> getMembers();
    Member getMemberById(String id);
    void saveToFile();
    void loadFromFile();
}
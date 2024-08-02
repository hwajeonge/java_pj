package java_pj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
    private List<Member> members;
    private static final String FILE_PATH = "members.dat";
    private static MemberDaoImpl instance = new MemberDaoImpl();

    private MemberDaoImpl() {
        members = new ArrayList<>();
        loadFromFile();
    }

    public static MemberDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> getMembers() {
        return members;
    }

    @Override
    public Member getMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                members = (List<Member>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

package java_pj;

public class MainUI {
    public void service() {
        VideoUi videoUi = VideoUi.getInstance();
        videoUi.service();
    }
    
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}

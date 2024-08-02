package java_pj;

import java.util.Scanner;
import java.util.List;

public class VideoUi {
    private VideoDao videoDao = VideoDaoImpl.getInstance();
    private static VideoUi instance = new VideoUi();
    private Scanner sc = new Scanner(System.in);

    private VideoUi() {}

    public static VideoUi getInstance() {
        return instance;
    }

    public void service() {
        while (true) {
            System.out.println("=================================================");
            System.out.println("              자바로 구현하는 SSAFIT              ");
            System.out.println("-------------------------------------------------");
            System.out.println("1. 영상정보");
            System.out.println("0. 종료");
            System.out.println("-------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            
            int menu = sc.nextInt();
            
            switch (menu) {
                case 1:
                    videoInfoMenu();
                    break;
                case 0:
                    MainUI mainUi = new MainUI();
                    mainUi.exit();
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }

    private void videoInfoMenu() {
        while (true) {
            System.out.println("=================================================");
            System.out.println("                 영상정보 메인화면                 ");
            System.out.println("-------------------------------------------------");
            System.out.println("1. 영상목록");
            System.out.println("0. 이전으로");
            System.out.println("-------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            
            int menu = sc.nextInt();
            
            switch (menu) {
                case 1:
                    listVideo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }

    public void listVideo() {
        List<Video> videos = videoDao.selectVideo();
        System.out.println("=================================================");
        System.out.println("                     영상목록                     ");
        System.out.println("-------------------------------------------------");
        System.out.println("전체 " + videos.size() + "개");
        
        int index = 1;
        for (Video video : videos) {
            System.out.println(index + ". " + video.getTitle());
            index++;
        }

        System.out.println("-------------------------------------------------");
        System.out.println("1. 영상상세");
        System.out.println("0. 이전으로");
        System.out.println("-------------------------------------------------");
        System.out.print("메뉴를 선택하세요 : ");
        
        int menu = sc.nextInt();
        
        switch (menu) {
            case 1:
                detailVideoSelection();
                break;
            case 0:
                return;
            default:
                System.out.println("잘못된 메뉴 선택입니다.");
        }
    }

    private void detailVideoSelection() {
        System.out.print("영상번호를 입력하세요 : ");
        int no = sc.nextInt();
        detailVideo(no);
    }

    public void detailVideo(int no) {
        Video video = videoDao.selectVideoByNo(no);
        if (video != null) {
            System.out.println("=================================================");
            System.out.println("                    영상상세화면                   ");
            System.out.println("-------------------------------------------------");
            System.out.println("번호 : " + video.getNo());
            System.out.println("제목 : " + video.getTitle());
            System.out.println("운동 : " + video.getPart());
            System.out.println("영상 URL : " + video.getUrl());
            System.out.println("-------------------------------------------------");
            System.out.println("1. 리뷰보기");
            System.out.println("0. 이전으로");
            System.out.println("-------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            
            int menu = sc.nextInt();
            
            switch (menu) {
                case 1:
                    VideoReviewUI videoReviewUi = VideoReviewUI.getInstance(no);
                    videoReviewUi.service();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        } else {
            System.out.println("해당 번호의 비디오가 없습니다.");
        }
    }
}

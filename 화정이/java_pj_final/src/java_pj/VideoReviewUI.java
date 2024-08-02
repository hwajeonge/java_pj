package java_pj;

import java.util.List;
import java.util.Scanner;

public class VideoReviewUI {
    private VideoReviewDao videoReviewDao = VideoReviewDaoImpl.getInstance();
    private static VideoReviewUI instance;
    private int videoNo;
    private Scanner sc = new Scanner(System.in);

    private VideoReviewUI(int videoNo) {
        this.videoNo = videoNo;
    }

    public static VideoReviewUI getInstance(int videoNo) {
        if (instance == null || instance.videoNo != videoNo) {
            instance = new VideoReviewUI(videoNo);
        }
        return instance;
    }

    public void service() {
        while (true) {
            System.out.println("=================================================");
            System.out.println("                 리뷰 관리 화면                    ");
            System.out.println("-------------------------------------------------");
            System.out.println("1. 리뷰목록");
            System.out.println("2. 리뷰등록");
            System.out.println("0. 이전으로");
            System.out.println("-------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            
            int menu = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 비우기
            
            switch (menu) {
                case 1:
                    listReview();
                    break;
                case 2:
                    registReview();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }

    public void listReview() {
        List<VideoReview> reviews = videoReviewDao.selectReview(videoNo);
        System.out.println("=================================================");
        System.out.println("                  리뷰 목록 화면                   ");
        System.out.println("-------------------------------------------------");
        System.out.println("전체 " + reviews.size() + "개");

        int index = 1;
        for (VideoReview review : reviews) {
            System.out.println(index + ". " + review.getNickName() + ": " + review.getContent());
            index++;
        }
        
        System.out.println("-------------------------------------------------");
        System.out.println("0. 이전으로");
        System.out.println("-------------------------------------------------");
        System.out.print("메뉴를 선택하세요 : ");
        
        int menu = sc.nextInt();
        
        if (menu == 0) {
            return;
        } else {
            System.out.println("잘못된 메뉴 선택입니다.");
        }
    }

    public void registReview() {
        Member loggedInMember = SessionManager.getInstance().getLoggedInMember();
        
        if (loggedInMember == null) {
            System.out.println("리뷰를 등록하려면 로그인이 필요합니다.");
            return;
        }

        System.out.print("내용을 입력하세요 : ");
        String content = sc.nextLine();
        
        VideoReview review = new VideoReview();
        review.setVideoNo(videoNo);
        review.setNickName(loggedInMember.getName());  // 로그인한 회원의 이름 사용
        review.setContent(content);
        
        videoReviewDao.insertReview(review);

        System.out.println("리뷰가 성공적으로 등록되었습니다.");
    }
}

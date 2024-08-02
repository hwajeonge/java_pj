package java_pj;

import java.util.List;
import java.util.Scanner;
import java_pj.VideoReview;
import java_pj.VideoReviewDao;
import java_pj.VideoReviewDaoImpl;

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
        sc.nextLine(); // 입력 버퍼 비우기
        System.out.print("이름을 입력하세요 : ");
        String nickName = sc.nextLine();
        System.out.print("내용을 입력하세요 : ");
        String content = sc.nextLine();
        
        VideoReview review = new VideoReview();
        review.setVideoNo(videoNo);
        review.setNickName(nickName);
        review.setContent(content);
        
        videoReviewDao.insertReview(review);

        System.out.println("리뷰가 성공적으로 등록되었습니다.");
    }
}
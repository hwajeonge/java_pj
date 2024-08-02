package java_pj;

import java.io.Serializable;

public class VideoReview implements Serializable {
    private static final long serialVersionUID = 1L;  // 직렬화 버전 ID

    private int videoNo;
    private int reviewNo;
    private String nickName;
    private String content;

    // 기본 생성자, 게터/세터 메서드 및 toString() 메서드

    public VideoReview() {}

    public VideoReview(int videoNo, int reviewNo, String nickName, String content) {
        this.videoNo = videoNo;
        this.reviewNo = reviewNo;
        this.nickName = nickName;
        this.content = content;
    }

    public int getVideoNo() {
        return videoNo;
    }

    public void setVideoNo(int videoNo) {
        this.videoNo = videoNo;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "VideoReview{" +
                "videoNo=" + videoNo +
                ", reviewNo=" + reviewNo +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

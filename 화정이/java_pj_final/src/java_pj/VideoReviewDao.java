package java_pj;

import java.util.List;
import java_pj.VideoReview;

public interface VideoReviewDao {
    int insertReview(VideoReview videoReview);
    List<VideoReview> selectReview(int videoNo);
}

package java_pj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java_pj.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao {
    private Map<Integer, List<VideoReview>> videoReviewDb = new HashMap<>();
    private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();

    private VideoReviewDaoImpl() {}

    public static VideoReviewDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int insertReview(VideoReview videoReview) {
        List<VideoReview> reviews = videoReviewDb.getOrDefault(videoReview.getVideoNo(), new ArrayList<>());
        reviews.add(videoReview);
        videoReviewDb.put(videoReview.getVideoNo(), reviews);
        return reviews.size(); // Return the size of the list as an indication of success
    }

    @Override
    public List<VideoReview> selectReview(int videoNo) {
        return videoReviewDb.getOrDefault(videoNo, new ArrayList<>());
    }
}
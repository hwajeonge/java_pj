package java_pj;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class VideoDaoImpl implements VideoDao {
    private List<Video> videoList;
    private static VideoDaoImpl instance = new VideoDaoImpl();

    private VideoDaoImpl() {
        // JSON 파일을 읽어와서 videoList에 저장
        loadVideosFromJson();
    }

    public static VideoDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Video> selectVideo() {
        return videoList;
    }

    @Override
    public Video selectVideoByNo(int no) {
        for (Video video : videoList) {
            if (video.getNo() == no) {
                return video;
            }
        }
        return null;
    }

    private void loadVideosFromJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("data/video.json")) { // 파일 경로 설정 필요
            Type videoListType = new TypeToken<List<Video>>(){}.getType();
            videoList = gson.fromJson(reader, videoListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package java_pj;

import java.util.List;

public interface VideoDao {
	public List<Video> selectVideo();
	public Video selectVideoByNo(int no);
}

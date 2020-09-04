package domain.VO;

public class PlaylistVO {
	private String title;
	//private String description;
	private String thumbnail;
	private String videoId;
	//private String videoTime;
	
	//public String getVideoTime() {
	//	return videoTime;
	//}
	//public void setVideoTime(String videoTime) {
	//	this.videoTime = videoTime;
	//}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//public String getDescription() {
	//	return description;
	//}
	//public void setDescription(String description) {
	//	this.description = description;
	//}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}

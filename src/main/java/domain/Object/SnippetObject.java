package domain.Object;

import java.util.List;

public class SnippetObject {
	private String channelId;
	private String title;
	private String description;
	private ThumbnailObjects thumbnails;
	private ResourceObject resourceId;

	public ResourceObject getResourceId() {
		return resourceId;
	}

	public void setResourceId(ResourceObject resourceId) {
		this.resourceId = resourceId;
	}

	public ThumbnailObjects getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(ThumbnailObjects thumbnails) {
		this.thumbnails = thumbnails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// 섬네일 필요시 여기에 추가

}

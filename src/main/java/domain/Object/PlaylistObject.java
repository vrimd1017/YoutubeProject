package domain.Object;

public class PlaylistObject {

	private String id;
	private SnippetObject snippet;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SnippetObject getSnippet() {
		return snippet;
	}
	public void setSnippet(SnippetObject snippet) {
		this.snippet = snippet;
	}
}

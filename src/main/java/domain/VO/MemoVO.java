package domain.VO;

public class MemoVO {
	private int memoCode;
	private String memoUpdatetime;
	private String memoTitle;
	private String memoContent;
	private int noteCode;
	private String memoThumbnail;
	private int memoTime;

	public String getMemoContent() {
		return memoContent;
	}

	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}

	public int getMemoCode() {
		return memoCode;
	}

	public void setMemoCode(int memoCode) {
		this.memoCode = memoCode;
	}

	public String getMemoUpdatetime() {
		return memoUpdatetime;
	}

	public void setMemoUpdatetime(String memoUpdatetime) {
		this.memoUpdatetime = memoUpdatetime;
	}

	public String getMemoTitle() {
		return memoTitle;
	}

	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}

	public int getNoteCode() {
		return noteCode;
	}

	public void setNoteCode(int noteCode) {
		this.noteCode = noteCode;
	}

	public String getMemoThumbnail() {
		return memoThumbnail;
	}

	public void setMemoThumbnail(String memoThumbnail) {
		this.memoThumbnail = memoThumbnail;
	}

	public int getMemoTime() {
		return memoTime;
	}

	public void setMemoTime(int memoTime) {
		this.memoTime = memoTime;
	}

}
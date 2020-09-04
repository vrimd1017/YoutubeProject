package domain.VO;

import com.google.gson.annotations.SerializedName;

public class NoteVO {
	int noteCode;
	String noteTitle;
	String noteContent;
	String noteUpdateTime;
	String noteUrl;
	String noteThumbnail;
	@SerializedName("categoryCode")
	int noteCategory;
	String userEmail;
	
	public int getNoteCode() {
		return noteCode;
	}
	public void setNoteCode(int noteCode) {
		this.noteCode = noteCode;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getNoteUpdateTime() {
		return noteUpdateTime;
	}
	public void setNoteUpdateTime(String noteUpdateTime) {
		this.noteUpdateTime = noteUpdateTime;
	}
	public String getNoteUrl() {
		return noteUrl;
	}
	public void setNoteUrl(String noteURL) {
		this.noteUrl = noteURL;
	}
	public String getNoteThumbnail() {
		return noteThumbnail;
	}
	public void setNoteThumbnail(String noteThumbnail) {
		this.noteThumbnail = noteThumbnail;
	}
	public int getNoteCategory() {
		return noteCategory;
	}
	public void setNoteCategory(int noteCategory) {
		this.noteCategory = noteCategory;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}

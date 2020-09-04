package interfaces;

import java.util.List;

import domain.VO.CategoryVO;
import domain.VO.NoteVO;

public interface NoteServiceInterface {
	public List<NoteVO> getNoteList(CategoryVO categoryVO);
	public void insertNote(NoteVO noteVO);
	public void deleteNote(NoteVO noteVO);
	public void updateNote(NoteVO noteVO);
}

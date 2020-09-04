package imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.VO.CategoryVO;
import domain.VO.NoteVO;
import interfaces.NoteServiceInterface;

@Service
public class NoteService implements NoteServiceInterface{
	@Autowired
	private NoteDao NoteDao;
	@Override
	public List<NoteVO> getNoteList(CategoryVO categoryVO){
		List<NoteVO> list = NoteDao.getCategoryItems(categoryVO);
		return list;
	}
	@Override
	public void insertNote(NoteVO noteVO) {
		System.out.println(noteVO.getNoteUrl());
		String noteURL = noteVO.getNoteUrl();
		int index = noteURL.indexOf("watch?v=")+8;
		System.out.println(noteURL.substring(index));
		noteVO.setNoteUrl(noteURL.substring(index));
		NoteDao.insertNote(noteVO);
		return;
	}
	@Override
	public void deleteNote(NoteVO noteVO) {
		NoteDao.deleteNote(noteVO);
		return;
	}
	@Override
	public void updateNote(NoteVO noteVO) {
		NoteDao.updateNote(noteVO);
		return;
	}
}

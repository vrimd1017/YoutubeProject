package interfaces;

import java.util.List;

import domain.VO.MemoVO;
import domain.VO.NoteVO;

public interface MemoDaoInterface {
	public List<MemoVO> getNoteItems(NoteVO noteVO);
	public int updateMemo(MemoVO memoVO);
	public int deleteMemo(MemoVO memoVO);
	public int insertMemo(MemoVO memoVO);
}

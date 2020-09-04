package interfaces;

import java.util.List;

import domain.VO.MemoVO;
import domain.VO.NoteVO;

public interface MemoServiceInterface {
	public List<MemoVO> getMemoList(NoteVO noteVO);
	public String updateMemo(MemoVO memoVO);
	public String deleteMemo(MemoVO memoVO);
	public String insertMemo(MemoVO memoVO);
}

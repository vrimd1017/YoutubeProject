package imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.VO.MemoVO;
import domain.VO.NoteVO;
import interfaces.MemoServiceInterface;

@Service
public class MemoService implements MemoServiceInterface{
	@Autowired
	private MemoDao MemoDao;
	@Override
	public List<MemoVO> getMemoList(NoteVO noteVO){
		List<MemoVO> list = MemoDao.getNoteItems(noteVO);
		return list;
	}
	@Override
	public String updateMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		int i = MemoDao.updateMemo(memoVO);
		if(i==0)return "fail";
		else return "succeed";
	}
	@Override
	public String deleteMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		int i = MemoDao.deleteMemo(memoVO);
		if(i==0)return "fail";
		else return "succeed";
	}
	@Override
	public String insertMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		int i = MemoDao.insertMemo(memoVO);
		if(i==0)return "fail";
		else return "succeed";
	}
	
}

package imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.VO.MemoVO;
import domain.VO.NoteVO;
import interfaces.MemoDaoInterface;

@Repository
public class MemoDao implements MemoDaoInterface{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<MemoVO> getNoteItems(NoteVO noteVO){
		return this.sqlSessionTemplate.selectList("myapp.mappers.MemoMapper.selectNote", noteVO);
	}
	@Override
	public int updateMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("myapp.mappers.MemoMapper.updateMemo", memoVO);
		
	}
	@Override
	public int deleteMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("myapp.mappers.MemoMapper.deleteMemo", memoVO);
		
	}
	@Override
	public int insertMemo(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("myapp.mappers.MemoMapper.insertMemo", memoVO);
		
	}
	
}

package imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.VO.CategoryVO;
import domain.VO.NoteVO;
import interfaces.NoteDaoInterface;

@Repository
public class NoteDao implements NoteDaoInterface{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<NoteVO> getCategoryItems(CategoryVO categoryVO){
		return this.sqlSessionTemplate.selectList("myapp.mappers.NoteMapper.selectCategory", categoryVO);
	}
	@Override
	public void insertNote(NoteVO noteVO) {
		
		this.sqlSessionTemplate.insert("myapp.mappers.NoteMapper.insertNote", noteVO);
		return;
	}
	@Override
	public void deleteNote(NoteVO noteVO) {
		this.sqlSessionTemplate.delete("myapp.mappers.NoteMapper.deleteNote", noteVO);
		return;
	}
	@Override
	public void updateNote(NoteVO noteVO) {
		this.sqlSessionTemplate.update("myapp.mappers.NoteMapper.updateNote", noteVO);
		return;
	}
}

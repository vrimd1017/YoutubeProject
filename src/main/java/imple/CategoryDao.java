package imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import domain.Object.CategoryArrObject;
import domain.Object.CategoryObject;
import domain.VO.CategoryVO;
import interfaces.CategoryDaoInterface;


@Repository
public class CategoryDao implements CategoryDaoInterface{
	

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//mybatis-spring lib에 존재.
	@Override
	public List<CategoryVO> list(){
		return this.sqlSessionTemplate.selectList("myapp.mappers.CategoryMapper.Categorylist");
	}
	@Override
	public int addOneCategory(CategoryVO categoryVO) {
		return this.sqlSessionTemplate.insert("myapp.mappers.CategoryMapper.insertOneCategory", categoryVO);
	}
	@Override
	public int deleteOneCategory(CategoryVO categoryVO) {
		return this.sqlSessionTemplate.delete("myapp.mappers.CategoryMapper.deleteOneCategory", categoryVO);
	}
	@Override
	public int updateCategory(CategoryVO categoryVO) {
		return this.sqlSessionTemplate.update("myapp.mappers.CategoryMapper.updateCategory", categoryVO);
	}
	@Override
	public List<CategoryObject> getUserSubCategories(CategoryArrObject categoryArrObject){
		return this.sqlSessionTemplate.selectList("myapp.mappers.CategoryMapper.getUserSubCategoryList", categoryArrObject);
	}
	@Override
	public List<CategoryArrObject> getUserCategories(CategoryVO categoryVO){
		return this.sqlSessionTemplate.selectList("myapp.mappers.CategoryMapper.getUserCategoryList", categoryVO);
	}
	@Override
	public CategoryVO selectCode(CategoryVO categoryVO) {
		return this.sqlSessionTemplate.selectOne("myapp.mappers.CategoryMapper.selectCode", categoryVO);
	}
	
	
}
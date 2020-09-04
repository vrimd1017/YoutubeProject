package interfaces;

import java.util.List;

import domain.Object.CategoryArrObject;
import domain.Object.CategoryObject;
import domain.VO.CategoryVO;

public interface CategoryDaoInterface {

	public List<CategoryVO> list();
	public int addOneCategory(CategoryVO categoryVO);
	public int deleteOneCategory(CategoryVO categoryVO);
	public int updateCategory(CategoryVO categoryVO);
	public List<CategoryObject> getUserSubCategories(CategoryArrObject categoryArrObject);
	public List<CategoryArrObject> getUserCategories(CategoryVO categoryVO);
	public CategoryVO selectCode(CategoryVO categoryVO);
}

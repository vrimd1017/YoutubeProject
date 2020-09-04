package interfaces;

import java.util.List;

import domain.Object.CategoryArrObject;
import domain.Object.CategoryObject;
import domain.VO.CategoryVO;

public interface CategoryServiceInterface {
		public List<CategoryVO> find();
		public String addOne(CategoryVO categoryVO);
		public String deleteOne(CategoryVO categoryVO);
		public List<CategoryObject> getUserSubCategories(CategoryArrObject categoryArrObject);
		public List<CategoryArrObject> getUserCategories(CategoryVO categoryVO);
		public String updateCategory(CategoryVO categoryVO);
		public int selectCode(CategoryVO categoryVO);
}

package imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Object.CategoryArrObject;
import domain.Object.CategoryObject;
import domain.VO.CategoryVO;
import interfaces.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface{
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<CategoryVO> find(){
		List<CategoryVO> listCategory = this.categoryDao.list();
		return listCategory;
	}
	//아래 두개는 나중에 경우에따라 변경.
	@Override
	public String addOne(CategoryVO categoryVO) {
		int i;
		i = this.categoryDao.addOneCategory(categoryVO);
		if(i==1) {
			return "succeed";
		}else {
			return "fail";
		}
	}
	@Override
	public String deleteOne(CategoryVO categoryVO) {
		int i;
		i = this.categoryDao.deleteOneCategory(categoryVO);
		if(i==1) {
			return "succeed";
		}else {
			return "fail";
		}
	}
	@Override
	public String updateCategory(CategoryVO categoryVO){
		int i;
		i = this.categoryDao.updateCategory(categoryVO);
		if(i==1) {
			return "succeed";
		}else {
			return "fail";
		}
	}
	
	@Override
	public List<CategoryArrObject> getUserCategories(CategoryVO categoryVO){
		List<CategoryArrObject> userCategories = this.categoryDao.getUserCategories(categoryVO);
		return userCategories;
	}
	@Override
	public int selectCode(CategoryVO categoryVO) {
		return this.categoryDao.selectCode(categoryVO).getCategoryCode();
	}
	
	@Override
	public List<CategoryObject> getUserSubCategories(CategoryArrObject categoryArrObject){
		/*
		List<CategoryVO> userCategories = this.categoryDao.getUserSubCategories(categoryVO);
		List<CategoryObject> userCategoryList = new ArrayList<>();
		for(CategoryVO vo : userCategories) {
			CategoryObject co = new CategoryObject();
			co.setCategoryName(vo.getCategoryName());
			co.setId(vo.getCategoryCode());
			userCategoryList.add(co);
		}
		return userCategoryList;
		*/
		List<CategoryObject> userCategories = this.categoryDao.getUserSubCategories(categoryArrObject);
		return userCategories;
	}
}

package domain.Object;

import java.util.List;

public class CategoryArrResponse {

	private int categoryCode;
	private String categoryName;
	private List<CategoryObject> categoryArr;
	


	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	public List<CategoryObject> getCategoryArr() {
		return categoryArr;
	}

	public void setCategoryArr(List<CategoryObject> categoryArr) {
		this.categoryArr = categoryArr;
	}
}

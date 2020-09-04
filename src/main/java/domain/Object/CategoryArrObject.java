package domain.Object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryArrObject {
	
	private int categoryCode;
	private String categoryName;
	//@Expose(deserialize = true)
	private String userEmail;

	private List<CategoryObject> categoryArr;


	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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

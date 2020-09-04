package domain.VO;



public class CategoryVO {
	//이제 생각한건데 cube였나? 그  특정 필드에 대해서 소계내는건데 이거 어떻게 활용하면
	//자바단에 VO리스트로 가져올때 활용할수 있을거같은데
	//일단은 지금 테스트 용이니까 다 집어 넣습니당.
	int categoryCode;
	int categoryParents;
	String categoryName;
	String userEmail;
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getCategoryParents() {
		return categoryParents;
	}
	public void setCategoryParents(int categoryParents) {
		this.categoryParents = categoryParents;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}

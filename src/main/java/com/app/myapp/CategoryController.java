package com.app.myapp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import domain.VO.CategoryVO;
import imple.CategoryService;

@Controller
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:5000")
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	
	//get?post?
	@RequestMapping(value="addonecategory")
	public String addOneCategory(@RequestParam("categoryName")String categoryName, @RequestParam("userEmail")String userEmail, @RequestParam(value="parentsCode", required=false)String parentsCode) {
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryName(categoryName);
		if(parentsCode!=null)
			categoryVO.setCategoryParents(Integer.parseInt(parentsCode));
		categoryVO.setUserEmail(userEmail);
		String res = categoryService.addOne(categoryVO);
		return res;
	}
	@RequestMapping(value="deleteonecategory")
	public String deleteOneCategory(@RequestParam("categoryCode")int categoryCode,@RequestParam("userEmail")String userEmail) {
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryCode(categoryCode);
		categoryVO.setUserEmail(userEmail);
		return categoryService.deleteOne(categoryVO);
	}
	

	@RequestMapping(value="updateCategory")
	public String updateCategogy(CategoryVO categoryVO) {
		return categoryService.updateCategory(categoryVO);
	}
}

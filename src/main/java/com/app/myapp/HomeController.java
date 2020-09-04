package com.app.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.VO.CategoryVO;
import imple.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource
	private CategoryService categoryService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model, CategoryVO categoryVO) throws Exception{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("serverTime",  formattedDate);
		
		//categoryVO.setUserEmail("vrimd1017@gmail.com");
		List<CategoryVO> listCategory = this.categoryService.find();
		modelAndView.addObject("listCategory", listCategory);
		return modelAndView;
		
	}
	
}

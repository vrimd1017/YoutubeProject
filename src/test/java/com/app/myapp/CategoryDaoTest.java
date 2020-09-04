package com.app.myapp;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.VO.CategoryVO;
import imple.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
// location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class CategoryDaoTest {
	// DAO 를 구현한 객체 자동으로 생성

	@Inject
	private CategoryService categoryService;

	@Test // @Test 전에 실행
	public void testInsertMember() throws Exception {
		System.out.println(categoryService.find().get(0).getCategoryName());
		System.out.println(categoryService.find().get(1).getCategoryName());
	}

}

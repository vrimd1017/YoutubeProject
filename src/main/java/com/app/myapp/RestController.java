package com.app.myapp;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import Parts.YoutubeFunc;
import domain.Object.CategoryArrObject;
import domain.Object.CategoryArrResponse;
import domain.Object.CategoryObject;
import domain.VO.CategoryVO;
import domain.VO.MemoVO;
import domain.VO.NoteVO;
import domain.VO.PlaylistVO;
import domain.VO.SimplePlaylistVO;
import imple.CategoryService;
import imple.MemoService;
import imple.NoteService;
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:5000")
@Controller
public class RestController {
	@Resource
	private CategoryService categoryservice;
	@Resource
	private NoteService noteService;
	@Resource
	private MemoService memoService;
	//유튜브 단순 재생목록 조회
		@ResponseBody
		@RequestMapping(value = "getsimplecategorylist", method = RequestMethod.GET, produces = "text/plain; charset=utf8")
		public String getSimpleCategoryList(HttpServletRequest request){
			String access_token = (String)request.getSession().getAttribute("access_token");
			YoutubeFunc youtubeFunc = new YoutubeFunc();
			List<SimplePlaylistVO> list = youtubeFunc.getPlaylist(access_token);
			Gson gson = new Gson();
			String jsonString = gson.toJson(list);
			return jsonString;
			//응답코드, 메시지, list로해서 클래스만 만들면 되긴 함.
		}
		    
	//유튜브 선택된 재생목록 동영상들 조회
		@ResponseBody
		@RequestMapping(value="getcategoryitemlist", method=RequestMethod.GET, produces="text/plain; charset=utf8")
		public String getCategoryItemList(HttpServletRequest request,  @RequestParam("id")String id, @RequestParam("title")String title) {
			//String access_token = (String)request.getSession().getAttribute("access_token");
			String userEmail = (String)request.getSession().getAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID");
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setUserEmail(userEmail);
			categoryVO.setCategoryName(title);
			categoryservice.addOne(categoryVO);
			YoutubeFunc youtubeFunc = new YoutubeFunc();
			List<PlaylistVO> list = youtubeFunc.getPlaylistItems(id);
			int newCategoryCode = categoryservice.selectCode(categoryVO);
			
			for(PlaylistVO vo : list) {
				NoteVO noteVO = new NoteVO();
				noteVO.setNoteCategory(newCategoryCode);
				noteVO.setUserEmail(userEmail);
				noteVO.setNoteThumbnail(vo.getThumbnail());
				noteVO.setNoteUrl(vo.getVideoId());
				noteVO.setNoteTitle(vo.getTitle());
				noteService.insertNote(noteVO);
			}
			//Gson gson = new Gson();
			//String jsonString = gson.toJson(list);
			
			
			//추가할 카테고리의 목록이 정해졌다는건...
			//DB상에는 해당 카테고리의 추가와
			//노트의 추가가 필요함.
			
			return "forward:/getusercategorylist?userEmail="+userEmail;
			//응답코드, 메시지, list로해서 클래스만 만들면 되긴 함.
		}
		
		//POST로 전환 GET은 크롬 전시용
		@ResponseBody
		@RequestMapping(value="getusercategorylist", method=RequestMethod.GET, produces="text/plain; charset=utf8" )
		public String getUserCategoryList(HttpServletRequest request, @RequestParam(value="userEmail")String userEmail) {
			//session에서 받아오는게 맞을거같은데..음... 일단 post로 받는거로..
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setUserEmail(userEmail);
			List<CategoryArrObject> userCategory = categoryservice.getUserCategories(categoryVO);
			
			for(CategoryArrObject cao : userCategory) {
				cao.setUserEmail(userEmail);
				List<CategoryObject> userSubCategory = categoryservice.getUserSubCategories(cao);
				cao.setCategoryArr(userSubCategory);
			}
			//CategoryArrResponse res = new CategoryArrResponse();
			//res.setCategoryArr(userCategory.get);
			Gson gson = new Gson();
			String jsonString = gson.toJson(userCategory);
			
			return jsonString;
		}
		
		//POST로 전환 GET은 크롬 전시용
		@ResponseBody
		@RequestMapping(value="getCategoryItems", method=RequestMethod.GET, produces="text/plain; charset=utf8")
		public String getCategoryItems(HttpServletRequest request, @RequestParam(value="userEmail")String userEmail, @RequestParam(value="categoryCode")int categoryCode) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setUserEmail(userEmail);
			categoryVO.setCategoryCode(categoryCode);
			List<NoteVO> categoryItems = noteService.getNoteList(categoryVO);
			Gson gson = new Gson();
			String jsonString = gson.toJson(categoryItems);
			return jsonString;
		}
		
		@ResponseBody
		@RequestMapping(value="getNoteItems", method=RequestMethod.GET, produces="text/plain; charset=utf8")
		public String getNoteItems(HttpServletRequest request, @RequestParam(value="noteCode")int noteCode) {
			NoteVO noteVO = new NoteVO();
			noteVO.setNoteCode(noteCode);
			List<MemoVO> noteItems = memoService.getMemoList(noteVO);
			Gson gson = new Gson();
			String jsonString = gson.toJson(noteItems);
			return jsonString;
		}
}

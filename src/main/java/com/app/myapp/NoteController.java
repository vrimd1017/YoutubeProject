package com.app.myapp;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import domain.VO.CategoryVO;
import domain.VO.NoteVO;
import imple.NoteService;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:5000")
@Controller
public class NoteController {
	@Autowired
	private NoteService noteService;
	private Gson gson = new Gson();
	//결과
	//RestController :: getCategoryItems 호출.
	@ResponseBody
	@RequestMapping(value="insertNote", method = RequestMethod.POST, produces="text/plain; charset=utf8")
	public String insertNote(HttpServletRequest request, @RequestBody NoteVO noteVO) {
		//Enumeration<String> iter = request.getSession().getAttributeNames();
		//while(iter.hasMoreElements()) {
	//		System.out.println("노트세션 :"+ iter.nextElement());
		//}
		
		String userEmail = (String)request.getSession().getAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID");
		System.out.println("----------------");
		System.out.println(noteVO.getNoteTitle());
		System.out.println(noteVO.getNoteContent());
		System.out.println(noteVO.getNoteUrl());
		System.out.println("Email : "+userEmail);
		System.out.println("----------------");
		
		noteVO.setUserEmail(userEmail);
		noteService.insertNote(noteVO);
		//String userEmail = (String)request.getSession().getAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID");
		System.out.println("session : " +userEmail);
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryCode(noteVO.getNoteCategory());
		categoryVO.setUserEmail(userEmail);
		List<NoteVO> list = noteService.getNoteList(categoryVO);
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	@ResponseBody
	@RequestMapping(value="deleteNote", produces="text/plain; charset=utf8")
	public String deleteNote(HttpServletRequest request, @RequestBody NoteVO noteVO) {
		noteService.deleteNote(noteVO);
		String userEmail = (String)request.getSession().getAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID");
		System.out.println("Email : "+userEmail);
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryCode(noteVO.getNoteCategory());
		categoryVO.setUserEmail(userEmail);
		List<NoteVO> list = noteService.getNoteList(categoryVO);
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	@ResponseBody
	@RequestMapping(value="updateNote", produces="text/plain; charset=utf8")
	public String updateNote(HttpServletRequest request, @RequestBody NoteVO noteVO) {
		noteService.updateNote(noteVO);
		String userEmail = (String)request.getSession().getAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID");
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryCode(noteVO.getNoteCategory());
		categoryVO.setUserEmail(userEmail);
		List<NoteVO> list = noteService.getNoteList(categoryVO);
		String jsonString = gson.toJson(list);
		return jsonString;
	}

}

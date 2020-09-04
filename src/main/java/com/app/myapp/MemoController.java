package com.app.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import domain.VO.MemoVO;
import domain.VO.NoteVO;
import imple.MemoService;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:5000")
@Controller
public class MemoController {
	@Autowired
	private MemoService memoService;
	
	
	@ResponseBody
	@RequestMapping(value="updateMemo", produces="text/plain; charset=utf8")
	public String updateMemo(MemoVO memoVO) {
		NoteVO noteVO = new NoteVO();
		noteVO.setNoteCode(memoVO.getNoteCode());
		memoService.updateMemo(memoVO);
		List<MemoVO> list = memoService.getMemoList(noteVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteMemo", produces="text/plain; charset=utf8")
	public String deleteMemo(MemoVO memoVO) {
		NoteVO noteVO = new NoteVO();
		noteVO.setNoteCode(memoVO.getNoteCode());
		memoService.deleteMemo(memoVO);
		List<MemoVO> list = memoService.getMemoList(noteVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	
	@ResponseBody
	@RequestMapping(value="insertMemo", produces="text/plain; charset=utf8")
	public String insertMemo(@RequestBody MemoVO memoVO) {
		//MemoVO memoVO = gson.fromJson(json, typeOfT)
		NoteVO noteVO = new NoteVO();
		noteVO.setNoteCode(memoVO.getNoteCode());
		memoService.insertMemo(memoVO);
		List<MemoVO> list = memoService.getMemoList(noteVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	
	@ResponseBody
	@RequestMapping(value="insertMemo2", produces="text/plain; charset=utf8")//지정안해주니 반환 한글에 ?가 되버리네
	public String insertMemo2(MemoVO memoVO) {
		NoteVO noteVO = new NoteVO();
		noteVO.setNoteCode(memoVO.getNoteCode());
		memoService.insertMemo(memoVO);
		List<MemoVO> list = memoService.getMemoList(noteVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		return jsonString;
		
		
	}
	
}
package com.app.myapp;

import java.util.Enumeration;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import domain.Object.ResponseObject;
import domain.VO.UserVO;
import imple.UserService;
import ofMail.AuthMail;
import ofMail.KeyUtils;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:5000")
@Controller
//@SessionAttributes("YOUTUBE_STUDY_HELPER_SESSION_ID")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	Gson gson = new Gson();
	
	@RequestMapping(value = "registUser", method = RequestMethod.GET)
	public String registUser(HttpServletRequest request) {
		return "registForm";
	}

	@ResponseBody
	@RequestMapping(value = "registUser", method = RequestMethod.POST, produces="text/plain; charset=utf8")
	public String authUser(HttpServletRequest request,@RequestBody UserVO userVO) {

		AuthMail authMail = null;
		MimeMessageHelper helper = null;
		MimeMessage message = null;
		ResponseObject response = new ResponseObject();
		String jsonString=null;
		
		KeyUtils keyUtils = new KeyUtils();
		String key = keyUtils.makeKey();
		userVO.setUserCode(key);
		userService.registUser(userVO);
		try {

			authMail = new AuthMail(mailSender);

			helper = authMail.getMessageHelper();

			message = authMail.getMessage();

			helper.setSubject("회원가입에 따른 인증 이메일입니다.");
			helper.setFrom("vrimd1017@gmail.com");
			helper.setTo(userVO.getUserEmail());
			System.out.println("텍스트작성중");
			
			helper.setText("<h1>메일인증</h1>" + "<a href='http://110.11.49.218:8080/myapp/confirmEmail?userEmail="
					+ userVO.getUserEmail() + "&userCode=" + key + "'" + ">이메일 인증 확인</a>");
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			response.setResponseCode(400);
			response.setMessage("메일관련 오류가 발생하였습니다. 다시진행해주세요");
			jsonString = gson.toJson(response);
			return jsonString;
		}
		
		response.setResponseCode(200);
		response.setMessage("성공적으로 메일이 발송되었습니다. 메일을 확인하여 인증을 진행해주세요");
		jsonString = gson.toJson(response);
		return jsonString;
		
	}
	
	@RequestMapping(value = "confirmEmail", method = RequestMethod.GET)
	public String confirmEmail(HttpServletRequest request, UserVO userVO) {
		System.out.println(userVO.getUserCode());
		String res = userService.updateAuth(userVO);
		
		return "redirect:https://youtube-study-helper.herokuapp.com";
	}

	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST,produces="text/plain; charset=utf8")
	public String login(HttpServletRequest request,@RequestBody UserVO userVO, HttpServletResponse rs) {
		HttpSession session = request.getSession();
		ResponseObject response = new ResponseObject();
		String jsonString = null;
		UserVO userInfo = userService.login(userVO);
		if (userInfo == null || userInfo.getUserEmail().isEmpty()) {
			response.setResponseCode(400);
			response.setMessage("회원정보가 존재하지 않습니다.");
			jsonString = gson.toJson(response);
			return jsonString;
		}
		if(userInfo.getUserAuth() == 0) {
			response.setResponseCode(401);
			response.setMessage("이메일 인증을 완료해 주세요");
			jsonString = gson.toJson(response);
			return jsonString;
		}
		
		
		//model.addAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID", userInfo.getUserEmail());
		
		request.getSession().setAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID", userInfo.getUserEmail());
		//Cookie cookie = new Cookie("YOUTUBE_STUDY_HELPER_SESSION_ID", userInfo.getUserEmail());
		//cookie.setMaxAge(3600);
		response.setResponseCode(200);
		response.setMessage(userInfo.getUserEmail()+" 로그인에 성공하셨습니다.");
		//rs.addCookie(cookie);
		
		jsonString = gson.toJson(response);
		
		
		
		Enumeration<String> iter = request.getSession().getAttributeNames();
		while(iter.hasMoreElements()) {
			System.out.println("로그인세션 :"+ iter.nextElement());
		}
		
		
		
		return jsonString;
		
	}
}

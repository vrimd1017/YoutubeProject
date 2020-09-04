package com.app.myapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

import Parts.OAuth_Path;
import domain.Token;
import domain.VO.UserVO;
import imple.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	
	@RequestMapping(value = "Auth")
	public String list(@RequestParam("code") String code, HttpServletRequest httpServletRequest) throws ServletException, IOException {
		OAuth_Path oauth_path = new OAuth_Path();
		System.out.println("code : ="+ code);
		String id = (String)httpServletRequest.getSession().getAttribute("YOUTUBE_STUDY_HELPER_SESSION_ID"); 
		//이 부분에서 session에서 못 읽어올 수 있습니다.
		
		//System.out.println("AuthController에서 Session접근 되나?");
		//session이 먹힐지도 사실 모르겠고
		//그 머야 youtube아이디랑 같아야되는데 이거 id가
		UserVO userVO = new UserVO();
		userVO.setUserEmail(id);
		//userVO.setUserCode(code);
		//userService.updateCode(userVO);
		
		Token token = oauth_path.getToken(code);
		
		System.out.println("유저 : "+id);
		System.out.println("토큰 : "+token.getAccess_token());
		httpServletRequest.getSession().setAttribute("token", token);
		httpServletRequest.getSession().setAttribute("access_token", token.getAccess_token());
		//아직 토큰은 얻었지만 이를 저장하거나 하긴 해야될거같은데....세션에 넣어놓는거로 하고...
		//나중에 다시 로그인했을때 어떻게 저장해놔야될거같은데 음
		//code를 저장해놔야되나
		//code를 저장해야겟다
		
		return "temp";
	}

	@RequestMapping(value = "Authres", method = RequestMethod.POST)
	public ModelAndView viewAccessToken() {
		ModelAndView modelAndView = new ModelAndView("/Authres");
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		System.out.println(jsonObject);

		return modelAndView;
	}

}

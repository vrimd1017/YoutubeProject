package imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.VO.UserVO;
import interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {
	@Autowired
	private UserDao userDao;

	@Override
	public UserVO login(UserVO userVO) {
		System.out.println("service : " + userVO.getUserEmail());
		UserVO userInfo = this.userDao.userlogin(userVO);
		return userInfo;
	}
	@Override
	public void updateCode(UserVO userVO) {
		System.out.println("updateCode");
		this.userDao.updateCode(userVO);
		return;
	}
	@Override
	public void registUser(UserVO userVO) {
		this.userDao.registUser(userVO);
		return;
	}
	@Override
	public String updateAuth(UserVO userVO) {
		int temp = this.userDao.updateAuth(userVO);
		if(temp==1)return "succeed";
		else return "fail";
		
	}
}

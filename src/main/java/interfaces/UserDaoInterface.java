package interfaces;

import domain.VO.UserVO;

public interface UserDaoInterface {
	public UserVO userlogin(UserVO loginVO);
	public void updateCode(UserVO userVO);
	public void registUser(UserVO userVO);
	public int updateAuth(UserVO userVO);
}

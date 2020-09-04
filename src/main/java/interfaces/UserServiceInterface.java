package interfaces;

import domain.VO.UserVO;

public interface UserServiceInterface {
		public UserVO login(UserVO userVO);
		public void updateCode(UserVO userVO);
		public void registUser(UserVO userVO);
		public String updateAuth(UserVO userVO);
}

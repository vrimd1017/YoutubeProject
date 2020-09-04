package imple;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.VO.UserVO;
import interfaces.UserDaoInterface;

@Repository
public class UserDao implements UserDaoInterface{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public UserVO userlogin(UserVO userVO) {
		return this.sqlSessionTemplate.selectOne("myapp.mappers.UserMapper.userlogin", userVO);
	}
	@Override
	public void updateCode(UserVO userVO) {
		this.sqlSessionTemplate.update("myapp.mappers.UserMapper.updateCode", userVO);
		return;
	}
	@Override
	public void registUser(UserVO userVO) {
		this.sqlSessionTemplate.insert("myapp.mappers.UserMapper.registUser", userVO);
		return;
	}
	@Override
	public int updateAuth(UserVO userVO) {
		return this.sqlSessionTemplate.update("myapp.mappers.UserMapper.updateAuth", userVO);
	}
}

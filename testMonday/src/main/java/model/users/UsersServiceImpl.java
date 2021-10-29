package model.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersDAO usersDAO;

	@Override
	public void insertUsers(UsersVO vo) {
		usersDAO.insertUsers(vo);
	}

	@Override
	public void updateUsers(UsersVO vo) {
		usersDAO.updateUsers(vo);
	}

	@Override
	public void deleteUsers(UsersVO vo) {
			usersDAO.deleteUsers(vo);
	}

	@Override
	public List<UsersVO> getUsersList(UsersVO vo) {
		return usersDAO.selectAllUsers(vo);
	}

	@Override
	public UsersVO getUsers(UsersVO vo) {
		try {
			return usersDAO.selectOneUsers(vo);
		}
		catch(Exception e) {
			return null;
		}
	}

}

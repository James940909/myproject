package model.users;

import java.util.List;

public interface UsersService {
	void insertUsers(UsersVO vo);
	void updateUsers(UsersVO vo);
	void deleteUsers(UsersVO vo);
	void cntUp(UsersVO vo);
	List<UsersVO> getUsersList(UsersVO vo);
	UsersVO getUsers(UsersVO vo);
	List<UsersVO> ranking(UsersVO vo);
}

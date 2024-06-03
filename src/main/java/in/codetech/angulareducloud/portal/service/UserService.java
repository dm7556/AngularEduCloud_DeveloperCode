package in.codetech.angulareducloud.portal.service;

import java.util.List;
import java.util.Set;

import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.model.UserRole;

public interface UserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	//get user by username
	public User getUser(String username);

	//delete user by id
	public void deleteUser(Long userId);

	public List<User> getAllUsersDetails();
}

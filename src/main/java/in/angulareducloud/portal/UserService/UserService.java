package in.angulareducloud.portal.UserService;

import java.util.Set;

import org.springframework.stereotype.Service;

import in.angulareducloud.portal.model.User;
import in.angulareducloud.portal.model.UserRole;

@Service
public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles)throws Exception;
	
	public User getUser(String username);
	
	public User deleteUser(long id);
	
	
}

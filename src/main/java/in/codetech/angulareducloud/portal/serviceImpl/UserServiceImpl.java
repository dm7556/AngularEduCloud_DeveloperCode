package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.Exception.UserFoundException;
import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.model.UserRole;
import in.codetech.angulareducloud.portal.repository.RoleRepository;
import in.codetech.angulareducloud.portal.repository.UserRepository;
import in.codetech.angulareducloud.portal.repository.UserRoleRepository;
import in.codetech.angulareducloud.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;
	public User createUser(User user, Set<UserRole> userRoles)  {
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("User is already there !!");
			throw new UserFoundException("User is found with a given userId"+user.getId());
		} else { // user create
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			//user.setUserRoles(userRoles);
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;

	}

	public User getUser(String username) {
		User getUserByUsername = this.userRepository.findByUsername(username);
		return getUserByUsername;
	}

	public void deleteUser(Long userId) {
//		this.userRepository.findby
//		this.roleRepository.deleteById(userId);
//		this.userRepository.deleteById(userId);
	}

	@Override
	public List<User> getAllUsersDetails() {
		// TODO Auto-generated method stub
		List<User> findAll = this.userRepository.findAll();
		return findAll;
		
	}

}

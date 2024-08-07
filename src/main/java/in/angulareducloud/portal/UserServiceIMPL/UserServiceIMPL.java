package in.angulareducloud.portal.UserServiceIMPL;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.angulareducloud.portal.UserService.UserService;
import in.angulareducloud.portal.model.User;
import in.angulareducloud.portal.model.UserRole;
import in.angulareducloud.portal.repository.RoleRepository;
import in.angulareducloud.portal.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception 
	{
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local !=null)
		{
			System.out.println("user is allready there");
		}
		else {
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRole().addAll(userRoles);
			local = this.userRepository.save(user);
		}
				return local;
	}

	@Override
	public User getUser(String username) 
	{
		
		return this.userRepository.findByUsername(username);
	}

	@Override
	public User deleteUser(long id) {
		
		 Optional<User>optional=userRepository.findById(id);
		 if(optional.isPresent())
		 {
			 userRepository.deleteById(id);
			 return optional.get();
		 }
		 
		 else {
			return new User();
		}
	
	}
	
	

}

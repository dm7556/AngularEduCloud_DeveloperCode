package in.angulareducloud.portal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.angulareducloud.portal.UserService.UserService;
import in.angulareducloud.portal.model.Role;
import in.angulareducloud.portal.model.User;
import in.angulareducloud.portal.model.UserRole;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception 
	
	{
		user.setProfile("default.png");
		
		
		Set<UserRole>roles=new HashSet<UserRole>();
		
		
		Role role = new Role();
			 role.setRoleId(103);
			 role.setRoleName("Normal");
			 
			 
			 UserRole userRole = new UserRole();
			 
			 		userRole.setUser(user);
			 		userRole.setRole(role);
			 		
			 	roles.add(userRole);
			 	
			 	return this.userservice.createUser(user, roles);
				
	}
	

}

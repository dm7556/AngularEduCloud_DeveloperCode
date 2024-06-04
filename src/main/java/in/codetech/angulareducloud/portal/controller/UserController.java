package in.codetech.angulareducloud.portal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.model.Role;
import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.model.UserRole;
import in.codetech.angulareducloud.portal.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//create User
	@PostMapping("/")
	public User addUser(@RequestBody User user) throws Exception {
		//Entire role
		Set<UserRole> roles=new HashSet<>();
		//setting for Entity Role 
		Role role=new Role();
		role.setRoleId(14L);
		role.setRoleName("NORMAL");
		//setting values for userrole
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		//set then value in entire role
		roles.add(userRole);
		User createUser = this.userService.createUser(user, roles);
		return createUser;
	}
	
	//Get User
	@GetMapping("/{username}")
	public User retriveUserDetails(@PathVariable String username) {
		User user = this.userService.getUser(username);
		return user;
	}
	
	//Delete User
	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable long id) {
		this.userService.deleteUser(id);
	}
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		List<User> allUsersDetails = this.userService.getAllUsersDetails();
		return allUsersDetails;
	}
}

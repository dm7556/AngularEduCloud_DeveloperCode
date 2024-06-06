package in.codetech.angulareducloud.portal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.Exception.UserNotFoundException;
import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) {
		User user = this.userRepository.findByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("User is not found with a given username: " + username);
		} else {
			return user;
		}
	}

}

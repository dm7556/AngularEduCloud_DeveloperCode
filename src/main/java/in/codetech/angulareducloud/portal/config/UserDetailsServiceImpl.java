package in.codetech.angulareducloud.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.Exception.UserNotFoundException;
import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= this.userRepository.findByUsername(username);
		if (user==null) {
			
			System.out.println("User no found");
			throw new UserNotFoundException("No user found !!");
		}
		
		return user;
	}

}

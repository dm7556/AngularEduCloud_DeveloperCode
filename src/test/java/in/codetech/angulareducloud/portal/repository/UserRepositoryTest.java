//package in.codetech.angulareducloud.portal.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import in.codetech.angulareducloud.portal.model.User;
//import junit.framework.TestCase;
//@DataJpaTest
//public class UserRepositoryTest extends TestCase {
////	private long id;
////	private String username;
////	private String password;
////	private String firstName;
////	private String lastName;
////	private String email;
////	private String phone;
////	private boolean enabled = true;
////	private String profile;
//	@Autowired
//	private UserRepository userRepository;
//
//	User user;
//	@BeforeEach
//	protected void setUp()  {
//		user=new User(1, "Har@1234", "Har@1234", "Harshad", "Mhatre", "mhatreharshad52@gmail.com", "7410150638", true, "default.png", null);
//		userRepository.save(user);
//	}
//	
//	@AfterEach
//	 protected void tearDown()  {
//		user=null;
//		userRepository.deleteAll();
//		
//	}
//
//	//test cases for success
//	@Test
//	void findByUsernameSucessCheck() {
//		User findByUsername = this.userRepository.findByUsername("Har@1234");
//		assertThat(findByUsername.getId()).isEqualTo(user.getId());
//	}
//	
//	//tset for failure
//	@Test
//	void findByUsernameFailureCheck() {
//		User findByUsername = this.userRepository.findByUsername("Har@12345");
//		assertThat(findByUsername).isNotNull();
//	}
//	
//}

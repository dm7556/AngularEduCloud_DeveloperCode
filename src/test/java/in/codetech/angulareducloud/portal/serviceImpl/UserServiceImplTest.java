//package in.codetech.angulareducloud.portal.serviceImpl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doAnswer;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Answers;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.stubbing.Answer;
//
//import in.codetech.angulareducloud.portal.model.User;
//import in.codetech.angulareducloud.portal.repository.UserRepository;
//import in.codetech.angulareducloud.portal.service.UserService;
//import junit.framework.TestCase;
//
//public class UserServiceImplTest extends TestCase {
//	
//	@Mock
//	private UserRepository userRepository;
//
//	private UserService userService;
//
//	AutoCloseable autoCloseable;
//	
//	User user;
//	
//	@BeforeEach
//	protected void setUp() throws Exception {
//		autoCloseable=MockitoAnnotations.openMocks(this);
//		userService = new UserServiceImpl(userRepository);
//		user=new User(1, "Har@1234", "Har@1234", "Harshad", "Mhatre", "mhatreharshad52@gmail.com", "7410150638", true, "default.png", null);
//		
//	}
//	
//	@AfterEach
//	protected void tearDown() throws Exception {
//		autoCloseable.close();
//	}
//
//
//	@Test
//	public void testCreateUser() throws Exception {
//		when(userRepository.save(user)).thenReturn(user);
//		assertThat(userService.createUser(user, null).getId()).isEqualTo(user.getId());
//	}
//	
//	@Test
//	public void testGetUser() {
//		
//		when(userRepository.findByUsername("Har@1234")).thenReturn(user);
//		assertThat(userService.getUser(user.getUsername()).getId()).isEqualTo(user.getId());
//		
//	}
//	
//	@Test
//	public void testDeleteUser() {
//		
//		    userService.deleteUser(1L);
//		    verify(userRepository).deleteById(user.getId());
//	}
//
//	@Test
//	public void testGetAllUsersDetails() {
//		
//		when(userRepository.findAll()).thenReturn(
//				new ArrayList<User>(Collections.singleton(user))
//				);
//		assertThat(userService.getAllUsersDetails().get(0).getId()).isEqualTo(user.getId());
//	}
//
//}

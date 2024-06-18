//package in.codetech.angulareducloud.portal.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import in.codetech.angulareducloud.portal.AngularEduCloudApplication;
//import in.codetech.angulareducloud.portal.config.JwtUtils;
//import in.codetech.angulareducloud.portal.config.UserDetailsServiceImpl;
//import in.codetech.angulareducloud.portal.controller.UserController;
//import in.codetech.angulareducloud.portal.model.Role;
//import in.codetech.angulareducloud.portal.model.User;
//import in.codetech.angulareducloud.portal.model.UserRole;
//import in.codetech.angulareducloud.portal.service.UserService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(UserController.class)
//@ContextConfiguration(classes = {AngularEduCloudApplication.class, JwtUtils.class, TestConfig.class})
//@Import({JwtUtils.class})
//@ExtendWith(MockitoExtension.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private UserDetailsServiceImpl userDetailsServiceImpl;
//
//    private List<User> users;
//
//    @BeforeEach
//    void setUp() {
//        Role roleAdmin = new Role(1, "ROLE_ADMIN", new HashSet<>());
//        Role roleUser = new Role(2, "ROLE_USER", new HashSet<>());
//
//        User user1 = new User(1, "Har@1234", "Har@1234", "Harshad", "Mhatre", "mhatreharshad52@gmail.com", "7410150638", true, "default.png", new HashSet<>());
//        User user2 = new User(2, "Har@12345", "Har@12345", "Harshad", "Mhatre", "mhatreharshad53@gmail.com", "7410150639", true, "default.png", new HashSet<>());
//
//        UserRole userRole1 = new UserRole(1, user1, roleAdmin);
//        UserRole userRole2 = new UserRole(2, user2, roleUser);
//
//        user1.getUserRoles().add(userRole1);
//        user2.getUserRoles().add(userRole2);
//
//        roleAdmin.getUserRoles().add(userRole1);
//        roleUser.getUserRoles().add(userRole2);
//
//        users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//    }
//
//    @AfterEach
//    void tearDown() {
//        users.clear();
//    }
////
////    @Test
////    @WithMockUser(username = "Har@1234", roles = { "USER" })
////    public void testRetrieveUserDetails() throws Exception {
////        when(userService.getUser("Har@1234")).thenReturn(users.get(0));
////
////        mockMvc.perform(get("/api/user/Har@1234"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id", is(1)))
////                .andExpect(jsonPath("$.username", is("Har@1234")))
////                .andExpect(jsonPath("$.firstName", is("Harshad")))
////                .andExpect(jsonPath("$.lastName", is("Mhatre")))
////                .andExpect(jsonPath("$.email", is("mhatreharshad52@gmail.com")));
////    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = { "ADMIN" })
//    public void testAddUser() throws Exception {
//        User newUser = new User(3, "newUser@123", "newUser@123", "New", "User", "newuser@example.com", "1234567890", true, "default.png", new HashSet<>());
//
//        when(userService.createUser(any(User.class), any(Set.class))).thenReturn(newUser);
//
//        mockMvc.perform(post("/api/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(newUser)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(3)))
//                .andExpect(jsonPath("$.username", is("newUser@123")))
//                .andExpect(jsonPath("$.firstName", is("New")))
//                .andExpect(jsonPath("$.lastName", is("User")))
//                .andExpect(jsonPath("$.email", is("newuser@example.com")));
//    }
//
////    @Test
////    @WithMockUser(username = "admin", roles = { "ADMIN" })
////    public void testRemoveUser() throws Exception {
////        Long userIdToRemove = 1L;
////
////        doNothing().when(userService).deleteUser(userIdToRemove);
////
////        mockMvc.perform(delete("/api/user/{userId}", userIdToRemove))
////                .andExpect(status().isOk());
////    }
////
////    @Test
////    @WithMockUser(username = "admin", roles = { "ADMIN" })
////    public void testGetAllUsers() throws Exception {
////        when(userService.getAllUsersDetails()).thenReturn(users);
////
////        mockMvc.perform(get("/api/users"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$", hasSize(2)))
////                .andExpect(jsonPath("$[0].id", is(1)))
////                .andExpect(jsonPath("$[0].username", is("Har@1234")))
////                .andExpect(jsonPath("$[1].id", is(2)))
////                .andExpect(jsonPath("$[1].username", is("Har@12345")));
////    }
//}

//Changes are done


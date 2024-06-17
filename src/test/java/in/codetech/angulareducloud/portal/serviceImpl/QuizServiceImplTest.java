//package in.codetech.angulareducloud.portal.serviceImpl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import in.codetech.angulareducloud.portal.model.Exam.Category;
//import in.codetech.angulareducloud.portal.model.Exam.Question;
//import in.codetech.angulareducloud.portal.model.Exam.Quiz;
//import in.codetech.angulareducloud.portal.repository.QuizRepository;
//import in.codetech.angulareducloud.portal.service.QuizService;
//
//class QuizServiceImplTest {
//    @Mock
//    private QuizRepository quizRepository;
//
//    private QuizService quizService;
//    
//    private Quiz quiz;
//    
//    private Category category;
//    
//    private Set<Question> questions;
//    
//    private Optional<Quiz> quiz2;
//    
//    private AutoCloseable autoCloseable;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        category = new Category();
//        category.setCid(1L);
//        category.setDescription("a");
//        category.setTitle("a");
//        
//        Question q1 = new Question();
//        q1.setQuesId(1L);
//        Question q2 = new Question();
//        q2.setQuesId(2L);
//        Question q3 = new Question();
//        q3.setQuesId(3L);
//        
//        questions = new HashSet<>(); // Initialize the Set
//        questions.add(q1);
//        questions.add(q2);
//        questions.add(q3);
//        
//        autoCloseable = MockitoAnnotations.openMocks(this);
//        quizService = new QuizServiceImpl(quizRepository);
//        
//        quiz = new Quiz(1L, "a", "a", "a", "a", false, category, questions);
//        quiz2 = Optional.of(quiz); // Initialize quiz2 with an optional quiz
//    }
//
//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }
//
//    @Test
//    void testAddQuiz() {
//        when(quizRepository.save(quiz)).thenReturn(quiz);
//        assertThat(quizService.addQuiz(quiz).getqId()).isEqualTo(quiz.getqId());
//    }
//
//    @Test
//    void testUpdateQuiz() {
//        Long qId = 1L;
//        Quiz updatedQuiz = new Quiz(1L, "a", "a", "a", "a", false, category, questions);
//        when(quizRepository.findById(qId)).thenReturn(quiz2);
//        when(quizRepository.save(quiz)).thenReturn(updatedQuiz);
//
//        
//        Quiz result = quizService.updateQuiz(updatedQuiz, qId);
//
//        
//        verify(quizRepository).findById(qId);
//        verify(quizRepository).save(quiz);
//        assertThat(result.getqId()).isEqualTo(updatedQuiz.getqId());
//        assertThat(result.getDiscription()).isEqualTo(updatedQuiz.getDiscription());
//    }
//
//    @Test
//    void testGetQuizzes() {
//        when(quizRepository.findAll()).thenReturn(
//        		new ArrayList<>(Collections.singleton(quiz)));
//        assertThat(quizService.getQuizzes().size()).isGreaterThanOrEqualTo(1);
//    }
//
//    @Test
//    void testGetQuiz() {
//    	when(quizRepository.findById(1L)).thenReturn(quiz2);
//		assertThat(quizService.getQuiz(1L).getTitle()).isEqualTo(quiz2.get().getTitle());
//    }
//
//    @Test
//    void testDeleteQuiz() {
//    	quizService.deleteQuiz(1L);
//		verify(quizRepository).deleteById(quiz.getqId());
//	
//    }
//}

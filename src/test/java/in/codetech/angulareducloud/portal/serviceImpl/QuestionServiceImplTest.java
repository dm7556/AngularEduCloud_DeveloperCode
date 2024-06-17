//package in.codetech.angulareducloud.portal.serviceImpl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedHashSet;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import in.codetech.angulareducloud.portal.model.Exam.Question;
//import in.codetech.angulareducloud.portal.model.Exam.Quiz;
//import in.codetech.angulareducloud.portal.repository.QuestionRepository;
//import in.codetech.angulareducloud.portal.service.QuestionService;
//import junit.framework.TestCase;
//
//class QuestionServiceImplTest extends TestCase {
//	
//	@Mock
//	private QuestionRepository questionRepository;
//
//	private QuestionService questionService;
//	
//	Question question;
//	private Quiz quiz;
//	Optional<Question> question2;
//	AutoCloseable autoCloseable;
//	@BeforeEach
//	protected void setUp() throws Exception {
//		 	quiz = new Quiz();
//	        quiz.setTitle("Python");
//	        quiz.setDiscription("This quiz is related to programming");
//	        quiz.setActive(true);
//		autoCloseable=MockitoAnnotations.openMocks(this);
//		questionService=new QuestionServiceImpl(questionRepository);
//        question = new Question(1L, "What is Python?", "a", "b", "c", "d", "a", "a", "a", quiz);
//        question2=Optional.of(question);
//	}
//
//	@AfterEach
//	protected void tearDown() throws Exception {
//		autoCloseable.close();
//	}
//
//	@Test
//	void testAddQuestion() {
//		when(questionRepository.save(question)).thenReturn(question);
//		assertThat(questionService.addQuestion(question).getQuesId()).isEqualTo(question.getQuesId());
//	}
//
//	@Test
//	void testUpdateQuestion() {
//		Long questionId = 1L;
//       Question updatedQuestion = new Question(1L, "What is Java?", "a", "b", "c", "d", "a", "a", "a", quiz);
//		when(questionRepository.findById(questionId)).thenReturn(question2);
//		when(questionRepository.save(question)).thenReturn(updatedQuestion);
//
//		// When
//		Question result = questionService.updateQuestion(updatedQuestion, questionId);
//
//		// Then
//		verify(questionRepository).findById(questionId);
//		verify(questionRepository).save(question);
//		assertThat(result.getQuesId()).isEqualTo(updatedQuestion.getQuesId());
//		assertThat(result.getAnswer()).isEqualTo(updatedQuestion.getAnswer());
//	}
//
//	@Test
//	void testGetQuestions() {
//		when(questionRepository.findAll()).thenReturn(
//				new ArrayList<Question>(Collections.singleton(question)));
//		assertThat(questionService.getQuestions().size()).isGreaterThanOrEqualTo(1);
//	}
//
//	@Test
//	void testGetQuestionById() {
//		when(questionRepository.findById(1L)).thenReturn(question2);
//		assertThat(questionService.getQuestion(1L).getAnswer()).isEqualTo(question2.get().getAnswer());
//	}
//
//	@Test
//	void testGetQuestionsOfQuiz() {
//		 when(questionRepository.findByQuiz(quiz)).thenReturn(new LinkedHashSet<Question>(Collections.singleton(question)));
//	        assertThat(questionService.getQuestionsOfQuiz(quiz).size()).isGreaterThanOrEqualTo(1);
//	}
//
//	@Test
//	void testDeleteQuestion() {
//		questionService.deleteQuestion(1L);
//		verify(questionRepository).deleteById(question.getQuesId());
//	}
//
//}

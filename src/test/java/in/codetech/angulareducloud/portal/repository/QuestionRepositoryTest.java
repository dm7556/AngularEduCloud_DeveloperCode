//package in.codetech.angulareducloud.portal.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Set;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import in.codetech.angulareducloud.portal.model.Exam.Question;
//import in.codetech.angulareducloud.portal.model.Exam.Quiz;
//
//@DataJpaTest
//class QuestionRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private QuestionRepository questionRepository;
//
//    private Quiz quiz;
//    private Question question;
//
//    @BeforeEach
//    void setUp() {
//        quiz = new Quiz();
//        quiz.setTitle("Python");
//        quiz.setDiscription("This quiz is related to programming");
//        quiz.setActive(true);
//        entityManager.persist(quiz);
//        question = new Question(null, "What is Python?", "a", "b", "c", "d", "a", "a", "a", quiz);
//        entityManager.persist(question);
//    }
//
//    @AfterEach
//    void tearDown() {
//        entityManager.clear();
//    }
//
//    @Test
//    void findByQuizTest() {
//        Set<Question> questions = questionRepository.findByQuiz(quiz);
//        assertThat(questions).hasSize(1);
//        assertThat(questions.iterator().next().getQuesId()).isEqualTo(question.getQuesId());
//    }
//}

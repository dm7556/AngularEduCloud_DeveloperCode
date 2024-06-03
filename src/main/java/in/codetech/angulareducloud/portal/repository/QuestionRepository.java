package in.codetech.angulareducloud.portal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.module.Exam.Question;
import in.codetech.angulareducloud.portal.module.Exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	Set<Question> findByQuiz(Quiz quiz);
}

package in.codetech.angulareducloud.portal.service;

import java.util.Set;

import in.codetech.angulareducloud.portal.module.Exam.Question;
import in.codetech.angulareducloud.portal.module.Exam.Quiz;

public interface QuestionService {
	public Question addQuestion(Question question);

	public Question updateQuestion(Question question,long quesId);

	public Set<Question> getQuestions();

	public Question getQuestion(Long questionId);

	public Set<Question> getQuestionsOfQuiz(Quiz quiz);

	public void deleteQuestion(Long quesId);

//	public Question get(Long questionId);
}

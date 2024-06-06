package in.codetech.angulareducloud.portal.serviceImpl;


import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.model.Exam.Question;
import in.codetech.angulareducloud.portal.model.Exam.Quiz;
import in.codetech.angulareducloud.portal.repository.QuestionRepository;
import in.codetech.angulareducloud.portal.repository.QuizRepository;
@Service
public class QuestionServiceImpl implements in.codetech.angulareducloud.portal.service.QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		Question save = this.questionRepository.save(question);
		return save;
	}

	@Override
	public Question updateQuestion(Question question, long quesId) {
		// TODO Auto-generated method stub
//		Optional<Question> findById = this.questionRepository.findById(quesId);
//		long quesId2 = findById.get().getQuesId();
//		this.questionRepository.deleteById(findById.get().getQuesId());
//		question.setQuesId(quesId2);
//		Question save = this.questionRepository.save(question);
//		
//		return save;
		  Question existingQuestion = questionRepository.findById(quesId).orElse(null);
	        if (existingQuestion != null) {
	            existingQuestion.setContent(question.getContent());
	            existingQuestion.setImage(question.getImage());
	            existingQuestion.setOption1(question.getOption1());
	            existingQuestion.setOption2(question.getOption2());
	            existingQuestion.setOption3(question.getOption3());
	            existingQuestion.setOption4(question.getOption4());
	            existingQuestion.setAnswer(question.getAnswer());
	            existingQuestion.setQuiz(question.getQuiz());
	            return questionRepository.save(existingQuestion);
	        }
	        return null;
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
//		Iterable<Question> findAll = this.questionRepository.findAll();	
//		return (Set<Question>) findAll;
		return new LinkedHashSet<>(questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		// TODO Auto-generated method stub
		Object findById = this.questionRepository.findById(questionId);
		return (Question) findById;
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		Set<Question> findByQuiz = this.questionRepository.findByQuiz(quiz);
		return findByQuiz;
	}

	@Override
	public void deleteQuestion(Long quesId) {
		// TODO Auto-generated method stub
		
	}

}

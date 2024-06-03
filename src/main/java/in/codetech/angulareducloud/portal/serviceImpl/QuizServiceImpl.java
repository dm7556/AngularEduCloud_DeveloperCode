package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.module.Exam.Category;
import in.codetech.angulareducloud.portal.module.Exam.Quiz;
import in.codetech.angulareducloud.portal.repository.QuizRepository;
@Service
public class QuizServiceImpl implements in.codetech.angulareducloud.portal.service.QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		Quiz save = this.quizRepository.save(quiz);
		return save;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz, long qId) {
		// TODO Auto-generated method stub
//		Optional<Quiz> findById = this.quizRepository.findById(qId);
//		long cId2 = findById.get().getqId();
//		this.quizRepository.deleteById(findById.get().getqId());
//		quiz.setqId(qId);;
//		Quiz save = this.quizRepository.save(quiz);
//		return save;
		 Quiz existingQuiz = quizRepository.findById(qId).orElse(null);
	        if (existingQuiz != null) {
	            existingQuiz.setTitle(quiz.getTitle());
	            existingQuiz.setDiscription(quiz.getDiscription());
	            existingQuiz.setMaxMarks(quiz.getMaxMarks());
	            existingQuiz.setNumberOfQuestions(quiz.getNumberOfQuestions());
	            existingQuiz.setActive(quiz.isActive());
	            existingQuiz.setCategory(quiz.getCategory());
	            existingQuiz.setQuestions(quiz.getQuestions());
	            return quizRepository.save(existingQuiz);
	        }
	        return null;
	}

	@Override
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
//		Iterable<Quiz> findAll = this.quizRepository.findAll();
//		return (Set<Quiz>) findAll;
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		 Quiz orElseThrow = this.quizRepository.findById(quizId).orElseThrow(null);
		 return orElseThrow;
		
	}

	@Override
	public void deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
		List<Quiz> findByCategory = this.quizRepository.findByCategory(category);
		return findByCategory;
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		// TODO Auto-generated method stub
		List<Quiz> findByActive = this.quizRepository.findByActive(true);
		return findByActive;
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		// TODO Auto-generated method stub
		List<Quiz> findByCategoryAndActive = this.quizRepository.findByCategoryAndActive(c, true);
		return findByCategoryAndActive;
	}

}

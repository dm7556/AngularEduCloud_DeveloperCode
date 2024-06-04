package in.codetech.angulareducloud.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.module.Exam.Category;
import in.codetech.angulareducloud.portal.module.Exam.Quiz;
import in.codetech.angulareducloud.portal.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		Quiz addQuiz = this.quizService.addQuiz(quiz);
		return addQuiz; 
	}
	
	@PutMapping("/{qId}")
	public Quiz updateQuiz(@RequestBody Quiz quiz,@PathVariable long qId) {
		Quiz updateQuiz = this.quizService.updateQuiz(quiz,qId);
		return updateQuiz;
	}
	
	@GetMapping("/{qId}")
	public Quiz getQuiz(@PathVariable long qId) {
		Quiz quiz = this.quizService.getQuiz(qId);
		return quiz;
	}
	
	@DeleteMapping("/{qId}")
	public void deleteQuiz(@PathVariable long qId) {
		this.quizService.deleteQuiz(qId);
	}
	
	@GetMapping("/category")
	public List<Quiz> getQuizzesByCategory(@RequestBody Category category){
		List<Quiz> quizzesOfCategory = this.quizService.getQuizzesOfCategory(category);
		return quizzesOfCategory;
	}
	
	@GetMapping("/active")
	public List<Quiz> getActiveQuizes(){
		List<Quiz> activeQuizzes = this.quizService.getActiveQuizzes();
		return activeQuizzes;
	}
	
	@GetMapping("/active/category")
	public List<Quiz> getActiveQuizesByCategory(@RequestBody Category category){
		List<Quiz> activeQuizzes = this.quizService.getActiveQuizzesOfCategory(category);
		return activeQuizzes;
	}
	
}

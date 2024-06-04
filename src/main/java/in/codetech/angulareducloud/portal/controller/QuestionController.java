package in.codetech.angulareducloud.portal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.module.Exam.Question;
import in.codetech.angulareducloud.portal.module.Exam.Quiz;
import in.codetech.angulareducloud.portal.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	//post question
	@PostMapping("/")
	public Question createQuestion(@RequestBody Question question) {
		Question addQuestion = this.questionService.addQuestion(question);
		return addQuestion;
	}
	
	//change the question
	@PutMapping("/")
	public Question updateQuestion(@RequestBody Question question,@PathVariable long quesId) {
		Question updateQuestion = this.questionService.updateQuestion(question, quesId);
		return updateQuestion;
	}
	
	//get all questions
	@GetMapping("/")
	public Set<Question> getAllQuestion(){
		Set<Question> questions = this.questionService.getQuestions();
		return questions;
	}
	//get question by question id
	@GetMapping("/{quesId}")
	public Question getQuestionById(@PathVariable long quesId) {
		Question question = this.questionService.getQuestion(quesId);
		return question;
	}
	
	
	@GetMapping("/quiz")
	public Set<Question> getAllQuestionByQuiz(@RequestBody Quiz quiz){
		Set<Question> questions = this.questionService.getQuestionsOfQuiz(quiz);
		return questions;
	}
	
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable long quesId) {
		this.questionService.deleteQuestion(quesId);
	}
}

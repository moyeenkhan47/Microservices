package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.model.Question;
import com.question.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
	
 private final QuestionService questionService;
 @PostMapping
 public Question create(@RequestBody Question question) {
	 return questionService.create(question);
 }
 @GetMapping
 public List<Question> getAll(){
	 return questionService.get();
	 
 }
 
 @GetMapping("/{questionId}")
 public Question getOne(@PathVariable Long questionId) {
	 return questionService.getOne(questionId);
 }
 
@GetMapping("/quiz/{quizId}")
public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
	return questionService.getQuestionsOfQuiz(quizId);
}
}

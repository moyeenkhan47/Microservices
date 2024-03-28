package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
	
	private final QuizService quizService;
	
	@PostMapping
	public Quiz create(@RequestBody  Quiz quiz) {
		return quizService.add(quiz);
	}
	
	@GetMapping
	public List<Quiz> get(Quiz quiz){
		List<Quiz> list = quizService.get();
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
		
	}
	@GetMapping("/{id}")
	public Quiz getOne(@PathVariable Long id){
		Quiz quiz = quizService.get(id);
		if(quiz.getId()!=id){
			return null;
		}else {
			return quiz;	
		}
		
	}

}

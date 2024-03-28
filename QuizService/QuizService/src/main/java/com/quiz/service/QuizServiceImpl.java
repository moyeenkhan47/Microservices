package com.quiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.model.Quiz;
import com.quiz.repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
	
	private final QuizRepository quizRepository; // Make it final to ensure it's initialized by the constructor
	private final QuestionClient questionClient;
     @Override
	public Quiz add(Quiz quiz) {
	
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		
		 List<Quiz> quizes = quizRepository.findAll();
		 List<Quiz> newQuizList = quizes.stream().map(quiz->{
			 quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			 return quiz;
			 
		 }).collect(Collectors.toList());
		 return newQuizList;
		 
	}

	@Override
	public Quiz get(Long id) {
		
		Quiz quiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("quiz not found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}

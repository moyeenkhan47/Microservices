package com.question.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.question.model.Question;
import com.question.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
	private final QuestionRepository questionRepository;

	@Override
	public Question create(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> get() {
		List<Question> all = questionRepository.findAll();
		return all;
	}

	@Override
	public Question getOne(Long id) {
		return  questionRepository.findById(id).orElseThrow(()-> new RuntimeException("question not found"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		
		return questionRepository.findByQuizId(quizId);
	}

}

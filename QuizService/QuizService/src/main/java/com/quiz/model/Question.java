package com.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class Question {
		@Id
		
		private Long questionId;
		private String question;
		private Long quizId;


}
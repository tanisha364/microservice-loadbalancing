package com.quiz.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
    private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;

	/*
	 * public QuizServiceImpl(QuizRepository quizRepository) { this.quizRepository =
	 * quizRepository; }
	 */

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
    	 List<Quiz> quizzes = quizRepository.findAll();

         List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
             quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
             return quiz;
         }).collect(Collectors.toList());

         return newQuizList;
    	//return quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {


        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    	//  return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found !!"));
    }
}

package ae.eskandar.quizapp.services;

import ae.eskandar.quizapp.dao.QuestionRepository;
import ae.eskandar.quizapp.dao.QuizRepository;
import ae.eskandar.quizapp.model.QuestionDao;
import ae.eskandar.quizapp.model.Quiz;
import ae.eskandar.quizapp.model.QuizDao;
import ae.eskandar.quizapp.model.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;

    private final QuizRepository quizRepository;

    private final QuestionService questionService;

    @Autowired
    public QuizService(QuestionRepository questionRepository, QuizRepository quizRepository, QuestionService questionService) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    public Quiz createQuiz(QuizDto quizDto, int count, String category) {


        List<QuestionDao> questions = questionService.getNQuestionsByCategory(category, count);

        return mapQuizDaoToQuiz(quizRepository.save(new QuizDao(quizDto.title(), questions)));
    }

    private Quiz mapQuizDaoToQuiz(QuizDao quizDao) {
        return new Quiz(
                quizDao.getTitle(),
                quizDao.getQuestions().stream().map(questionService::mapQuestionDaoToQuestion).toList()
        );
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll().stream().map(this::mapQuizDaoToQuiz).toList();
    }
}

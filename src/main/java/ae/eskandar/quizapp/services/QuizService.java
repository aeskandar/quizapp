package ae.eskandar.quizapp.services;

import ae.eskandar.quizapp.dao.QuizRepository;
import ae.eskandar.quizapp.model.QuestionDao;
import ae.eskandar.quizapp.model.Quiz;
import ae.eskandar.quizapp.model.QuizDao;
import ae.eskandar.quizapp.model.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuestionService questionService;

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuestionService questionService, QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
        this.questionService = questionService;
    }

    public Quiz createQuiz(QuizDto quizDto) {


        List<QuestionDao> questions = questionService.getNQuestionsByCategory(quizDto.questionCount(), quizDto.category());

        return mapQuizDaoToQuiz(quizRepository.save(new QuizDao(
                quizDto.title(),
                quizDto.questionCount(),
                quizDto.category(),
                questions
        )));
    }

    public Quiz mapQuizDaoToQuiz(QuizDao quizDao) {
        return new Quiz(
                quizDao.getTitle(),
                quizDao.getQuestionCount(),
                quizDao.getCategory(),
                quizDao.getQuestions().stream().map(questionService::mapQuestionDaoToQuestion).toList()
        );
    }

}

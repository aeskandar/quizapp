package ae.eskandar.quizapp.services;

import ae.eskandar.quizapp.dao.QuestionRepository;
import ae.eskandar.quizapp.model.Question;
import ae.eskandar.quizapp.model.QuestionDao;
import ae.eskandar.quizapp.model.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = this.questionRepository.findAll().stream().map(this::mapQuestionDaoToQuestion).toList();
        return questions;
    }

    public List<Question> getQuestionsByCategory(String category) {
        List<Question> questionsByCategory = this.questionRepository.findByCategory(category).stream().map(this::mapQuestionDaoToQuestion).toList();
        return questionsByCategory;
    }

    public Question addNewQuestion(QuestionDto questionDto) {

        QuestionDao questionDao = new QuestionDao(
                questionDto.getQuestionText(),
                questionDto.getCorrectAnswer(),
                questionDto.getCategory(),
                questionDto.getDifficulty(),
                questionDto.getOption1(),
                questionDto.getOption2(),
                questionDto.getOption3()
        );
        return mapQuestionDaoToQuestion(questionRepository.save(questionDao));
    }

    public List<QuestionDao> getNQuestionsByCategory(String category, int count) {
        List<QuestionDao> questions = this.getQuestionsByCategory(category).stream().limit(count).map(this::mapQuestionToQuestionDao).toList();

        return questions;
    }

    public Question mapQuestionDaoToQuestion(QuestionDao questionDao) {
        return new Question(
                questionDao.getQuestionText(),
                questionDao.getCorrectAnswer(),
                questionDao.getCategory(),
                questionDao.getDifficulty(),
                questionDao.getOption1(),
                questionDao.getOption2(),
                questionDao.getOption3()
        );
    }

    public QuestionDao mapQuestionToQuestionDao(Question question) {
        return new QuestionDao(
                question.getQuestionText(),
                question.getCorrectAnswer(),
                question.getCategory(),
                question.getDifficulty(),
                question.getOption1(),
                question.getOption2(),
                question.getOption3()
        );
    }
}

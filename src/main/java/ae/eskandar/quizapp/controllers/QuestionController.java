package ae.eskandar.quizapp.controllers;

import ae.eskandar.quizapp.model.Question;
import ae.eskandar.quizapp.model.QuestionDao;
import ae.eskandar.quizapp.model.QuestionDto;
import ae.eskandar.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = { "/all"})
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping(value = { "/category/{category}" })
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category), HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDto questionDto) {
        return new ResponseEntity<>(questionService.addNewQuestion(questionDto), HttpStatus.CREATED);
    }
}

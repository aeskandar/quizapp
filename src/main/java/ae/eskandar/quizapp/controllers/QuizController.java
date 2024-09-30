package ae.eskandar.quizapp.controllers;

import ae.eskandar.quizapp.model.Quiz;
import ae.eskandar.quizapp.model.QuizDto;
import ae.eskandar.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.OK);
    }
    @PutMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        QuizDto quizDto = new QuizDto(title);
        return new ResponseEntity<>(quizService.createQuiz(quizDto, numQ, category), HttpStatus.CREATED);
    }
}

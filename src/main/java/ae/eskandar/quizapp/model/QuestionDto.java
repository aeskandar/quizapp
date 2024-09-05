package ae.eskandar.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionDto {
    private String questionText;
    private String correctAnswer;
    private String category;
    private String difficulty;
    private String option1;
    private String option2;
    private String option3;
}

package ae.eskandar.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Question")
@NoArgsConstructor
public class QuestionDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq")
    @SequenceGenerator( name = "question_id_seq",
            sequenceName = "question_id_seq",
            allocationSize = 1)
    private Integer id;

    private String questionText;
    private String correctAnswer;
    private String category;
    private String difficulty;
    private String option1;
    private String option2;
    private String option3;

    public QuestionDao(String questionText, String correctAnswer, String category, String difficulty, String option1, String option2, String option3) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.difficulty = difficulty;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }
}

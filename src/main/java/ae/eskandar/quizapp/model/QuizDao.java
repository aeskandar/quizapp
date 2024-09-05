package ae.eskandar.quizapp.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@Entity(name = "Quiz")
@NoArgsConstructor
public class QuizDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_id_seq")
    @SequenceGenerator(name = "quiz_id_seq",
            sequenceName = "quiz_id_seq",
            allocationSize = 1)
    private Integer id;

    private String title;
    private int questionCount;
    private String category;

    @ManyToMany
    private List<QuestionDao> questions;


    public QuizDao(String title, int questionCount, String category, List<QuestionDao> questions) {
        this.title = title;
        this.questionCount = questionCount;
        this.category = category;
        this.questions = questions;
    }

}

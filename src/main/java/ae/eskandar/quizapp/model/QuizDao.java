package ae.eskandar.quizapp.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToMany
    private List<QuestionDao> questions;


    public QuizDao(String title, List<QuestionDao> questions) {
        this.title = title;
        this.questions = questions;
    }

}

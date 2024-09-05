package ae.eskandar.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Quiz {
    private String title;
    private int questionCount;
    private String category;
    private List<Question> questions;
}

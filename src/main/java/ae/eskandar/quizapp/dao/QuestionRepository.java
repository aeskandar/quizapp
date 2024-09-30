package ae.eskandar.quizapp.dao;

import ae.eskandar.quizapp.model.QuestionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionDao, Integer> {

    List<QuestionDao> findByCategory(String category);

    @Query(value = "SELECT * FROM question q where q.category=:category ORDER BY random() LIMIT :count", nativeQuery = true)
    List<QuestionDao> findRandomQuestionsByCategory(String category, int count);
}

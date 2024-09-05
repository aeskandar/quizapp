package ae.eskandar.quizapp.dao;

import ae.eskandar.quizapp.model.QuizDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizDao, Integer> {
}

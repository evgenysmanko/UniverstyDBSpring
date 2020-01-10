package university.repos;

import org.springframework.data.repository.CrudRepository;
import university.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}

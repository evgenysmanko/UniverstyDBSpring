package university.repos;

import org.springframework.data.repository.CrudRepository;
import university.domain.StudyGroup;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends CrudRepository<StudyGroup, Integer> {
    Optional<StudyGroup> findByName(String name);
    List<StudyGroup> findAll();
}

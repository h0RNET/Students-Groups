package universitygroups.mironenko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import universitygroups.mironenko.dto.StudentDto;
import universitygroups.mironenko.models.Students;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students, Integer> {
    List<Students> getStudentsByGroups_IdOrderByFullName(int idGroup);
}

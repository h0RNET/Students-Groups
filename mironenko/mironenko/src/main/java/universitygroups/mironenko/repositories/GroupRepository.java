package universitygroups.mironenko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import universitygroups.mironenko.dto.GroupDto;
import universitygroups.mironenko.models.Groups;

import java.util.List;


public interface GroupRepository extends JpaRepository<Groups, Integer> {
    //запрос на получение всех групп и количества студентов в каждой группе
    @Query("SELECT new universitygroups.mironenko.dto.GroupDto(g.id, g.number, count(s.id)) FROM Groups g LEFT JOIN g.students s ON g.id = s.groups.id  GROUP BY g.number")
    List<GroupDto> getJoinInformation();
    boolean existsByNumber(String number);
    Groups findByid(int idGroup);
}

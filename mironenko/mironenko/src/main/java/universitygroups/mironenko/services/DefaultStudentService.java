package universitygroups.mironenko.services;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import universitygroups.mironenko.dto.StudentDto;
import universitygroups.mironenko.models.Groups;
import universitygroups.mironenko.models.Students;
import universitygroups.mironenko.repositories.GroupRepository;
import universitygroups.mironenko.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
@Log
public class DefaultStudentService implements StudentsServices {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;
    private final GroupRepository groupRepository;

    @Override
    public List<StudentDto> getStudentsInSpecificGroup(int idGroup) {
        List<StudentDto> studentsList = new ArrayList<>();
        List<Students> students = studentRepository.getStudentsByGroups_IdOrderByFullName(idGroup);
        for(Students temp : students){
            studentsList.add(studentConverter.fromStudentsToStudentDto(temp));
        }
        return studentsList;
    }

    @Override
    public void deleteStudent(Integer idStudent) {
        try {
            studentRepository.deleteById(idStudent);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Groups groups = groupRepository.findById(studentDto.getIdGroup()).orElse(null);
        studentDto.setGroups(groups);
        Students students = studentRepository.save(studentConverter.fromStudentDtoToStudends(studentDto));
        return studentConverter.fromStudentsToStudentDto(students);
    }
}

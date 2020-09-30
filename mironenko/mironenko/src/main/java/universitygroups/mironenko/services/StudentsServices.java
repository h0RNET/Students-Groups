package universitygroups.mironenko.services;

import universitygroups.mironenko.dto.StudentDto;
import java.util.List;

public interface StudentsServices {
    List<StudentDto> getStudentsInSpecificGroup(int idGroup);
    void deleteStudent(Integer idStudent);
    StudentDto saveStudent(StudentDto studentDto);
}

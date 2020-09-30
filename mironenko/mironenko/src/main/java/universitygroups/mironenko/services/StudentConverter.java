package universitygroups.mironenko.services;


import org.springframework.stereotype.Component;
import universitygroups.mironenko.dto.StudentDto;
import universitygroups.mironenko.models.Students;

import java.util.Date;

@Component
public class StudentConverter {

    public StudentDto fromStudentsToStudentDto(Students students){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(students.getId());
        studentDto.setFullName(students.getFullName());
        studentDto.setEnrollmentDate(students.getEnrollmentDate());
        studentDto.setIdGroup(students.getGroups().getId());
        studentDto.setGroups(students.getGroups());
        return studentDto;
    }

    public Students fromStudentDtoToStudends(StudentDto studentDto){
        Students students = new Students();
        students.setId(studentDto.getId());
        students.setGroups(studentDto.getGroups());
        students.setFullName(studentDto.getFullName());
        students.setEnrollmentDate(new Date());
        return students;
    }
}

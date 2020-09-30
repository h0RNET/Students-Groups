package universitygroups.mironenko.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import universitygroups.mironenko.dto.StudentDto;
import universitygroups.mironenko.services.GroupsServices;
import universitygroups.mironenko.services.StudentsServices;

import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("/students")
@Log
public class StudentsController {

    private final StudentsServices studentsServices;
    private final GroupsServices groupsServices;

    @ModelAttribute("student")
    public StudentDto studentDto() {
        return new StudentDto();
    }

    @PostMapping(value = "/saveStudent", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    StudentDto saveStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudent = null;
        try {
            savedStudent = studentsServices.saveStudent(studentDto);
        } catch (NullPointerException e) {
            log.info(e.getMessage());
        }
        return savedStudent;
    }

    @GetMapping("/studentsList/{idGroup}")
    public String studentList(@PathVariable(value = "idGroup") int idGroup, Model model) {
        List<StudentDto> studentsList = studentsServices.getStudentsInSpecificGroup(idGroup);
        model.addAttribute("studentsList", studentsList);
        model.addAttribute("groupNumber",groupsServices.getSingleGroup(idGroup).getNumber());
        model.addAttribute("idGroup", idGroup);
        return "students";
    }

    @PostMapping("/deleteStudent/{idStudent}")
    public void deleteStudent(@PathVariable(value = "idStudent") int idStudent) {
            studentsServices.deleteStudent(idStudent);
    }
}

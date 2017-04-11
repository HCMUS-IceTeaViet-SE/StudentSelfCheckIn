package main.java.controller.user;

import main.java.controller.BaseController;
import main.java.model.Student;
import main.java.service.user.StudentService;

import java.util.List;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class StudentController extends BaseController {
    private StudentService studentService;
    public StudentController()
    {
        studentService = new StudentService();
    }

    public List<Student> getAllStudents()
    {
        return studentService.findAll();
    }
}

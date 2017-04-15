package main.java.controller.user;

import main.java.controller.BaseController;
import main.java.model.Student;
import main.java.service.user.StudentService;
import main.java.service.user.TeacherService;

import java.util.List;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class UserController extends BaseController {
    private StudentService studentService;
    private TeacherService teacherService;
    protected UserController()
    {
        studentService = new StudentService();
        teacherService = new TeacherService();
    }

    public List<Student> getAllStudents()
    {
        return studentService.findAll();
    }

    public static UserController getInstance() {
        if (instance == null)
            instance = new UserController();

        return (UserController) instance;
    }
}

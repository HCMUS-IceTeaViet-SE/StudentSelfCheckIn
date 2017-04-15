package main.java.controller.user;

import main.java.controller.BaseController;
import main.java.controller.subject.SubjectController;
import main.java.model.*;
import main.java.service.user.StudentService;
import main.java.service.user.TeacherService;

import java.util.*;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class UserController extends BaseController {
    private StudentService studentService;
    private TeacherService teacherService;

    protected UserController() {
        studentService = new StudentService();
        teacherService = new TeacherService();
    }

    public static UserController getInstance() {
        if (instance == null)
            instance = new UserController();

        return (UserController) instance;
    }

    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    public List<Student> getAllStudentBySubject(String subjectId)
    {
        return null;
    }



    public Map<ClassSubject,List<Boolean>> getCheckInDataByStudent(String studentId)
    {
        List<ClassSubject> subjectList = SubjectController.getInstance().getSubjectList(studentId);
        Map<ClassSubject, List<Boolean>> data = new HashMap<>();

        for (int i = 0; i < subjectList.size(); i++)
        {
            ClassSubject s = subjectList.get(i);
            data.put(s, SubjectController.getInstance().getCheckInData(s.getSubjectId(), studentId));
        }

        return data;
    }
}

package main.java.controller.user;

import main.java.controller.subject.SubjectController;
import main.java.model.ClassSubject;
import main.java.model.Student;
import main.java.service.user.StudentService;
import main.java.service.user.TeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class UserController {
    protected static UserController instance = null;
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

    public List<Student> getAllStudentBySubject(String subjectId) {
        return null;
    }


    public Map<ClassSubject, List<Boolean>> getCheckInDataByStudent(String studentId) {
        List<ClassSubject> subjectList = SubjectController.getInstance().getSubjectList(studentId);
        Map<ClassSubject, List<Boolean>> data = new HashMap<>();

        for (int i = 0; i < subjectList.size(); i++) {
            ClassSubject s = subjectList.get(i);
            data.put(s, SubjectController.getInstance().getCheckInData(s.getSubjectId(), studentId));
        }

        return data;
    }
}

package main.java.controller.subject;

import main.java.controller.BaseController;
import main.java.model.BaseModel;
import main.java.model.ClassSubject;
import main.java.model.Student;
import main.java.model.Timetable;
import main.java.service.subject.AttendanceService;
import main.java.service.subject.ClassSubjectService;
import main.java.service.subject.TimeTableService;
import main.java.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class SubjectController extends BaseController {
    private ClassSubjectService subjectService;
    private TimeTableService timeTableService;
    private AttendanceService attendanceService;
    protected SubjectController()
    {
        subjectService = new ClassSubjectService();
        timeTableService = new TimeTableService();
        attendanceService = new AttendanceService();
    }

    public static String[] getColumnNames()
    {
        String[] res = {"Mã môn học",
                "Tên môn học",
                "Sĩ số",
                "Danh sách"};
        return res;
    }

    public boolean addNewSubject(ClassSubject subject)
    {
        return subjectService.save(subject);
    }

    public boolean addNewTimeTable(Timetable timetable)
    {
        return timeTableService.save(timetable);
    }

    public List<Student> getStudentList(String subjectId)
    {
        ClassSubject subject = subjectService.findOne(subjectId);
        return new ArrayList<Student>(subject.getStudents());
    }

    public boolean addStudentToSubject(String subjectId, Student student)
    {
        ClassSubject subject = subjectService.findOne(subjectId);
        subject.addStudent(student);

        //Update to db
        return subjectService.update(subject);
    }

    public boolean addStudentListToSubject(String subjectId, List<Student> studentList)
    {
        ClassSubject subject = subjectService.findOne(subjectId);
        Set<Student> set = subject.getStudents();

        for (int i = 0; i < studentList.size(); i++) {
            set.add(studentList.get(i));
        }

        //Update to db
        subject.setStudents(set);
        return subjectService.update(subject);
    }

    public boolean addStudentListToSubject(String subjectId, String csvPath)
    {
        ClassSubject subject = subjectService.findOne(subjectId);
        Set<Student> set = subject.getStudents();

        try {
            set = importFromCSV(csvPath, true, set);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Update to db
        subject.setStudents(set);
        return subjectService.update(subject);
    }

    public static SubjectController getInstance() {
       if (instance == null)
           instance = new SubjectController();

       return (SubjectController) instance;
    }

    /**
     * Import a list of student from CSV file
     *
     * @param  filePath the string path of data file
     * @param isOverwriten flag to determine whether to overwrite the old data or not
     */
    public Set<Student> importFromCSV(String filePath, boolean isOverwriten, Set<Student> data) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));

        if (isOverwriten)
            data.clear();

        while (scanner.hasNext()) {
            List<String> attr = FileUtils.parseLine(scanner.nextLine());
            try {
                String studentId = attr.get(0);
                String studentName = attr.get(1);
                String usrName = attr.get(2);
                String className = attr.get(3);
                String sex = attr.get(4);
                Date dob = attr.get(5);
                String address = attr.get(6);
                Set classsubjects = classsubjects;
                Set attendances = attendances;
                Student s = new Student(attr);
                data.add(s);
            }

        }
        scanner.close();

        return data;
    }
}

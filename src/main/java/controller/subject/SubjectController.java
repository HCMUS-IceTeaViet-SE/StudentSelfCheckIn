package main.java.controller.subject;

import main.java.controller.BaseController;
import main.java.model.*;
import main.java.service.subject.AttendanceService;
import main.java.service.subject.ClassSubjectService;
import main.java.service.subject.StudentSubjectService;
import main.java.service.subject.TimeTableService;
import main.java.utils.FileUtils;

import javax.security.auth.Subject;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class SubjectController extends BaseController {
    private ClassSubjectService subjectService;
    private TimeTableService timeTableService;
    private AttendanceService attendanceService;
    private StudentSubjectService studentSubjectService;

    protected SubjectController() {
        subjectService = new ClassSubjectService();
        timeTableService = new TimeTableService();
        attendanceService = new AttendanceService();
        studentSubjectService = new StudentSubjectService();
    }

    public static String[] getColumnNames() {
        String[] res = {"Mã môn học",
                "Tên môn học",
                "Sĩ số",
                "Danh sách"};
        return res;
    }

    public static SubjectController getInstance() {
        if (instance == null)
            instance = new SubjectController();

        return (SubjectController) instance;
    }

    public List<ClassSubject> getSubjectList()
    {
        return subjectService.findAll();
    }

    public boolean addNewSubject(ClassSubject subject) {
        return subjectService.save(subject);
    }

    public boolean addNewTimeTable(Timetable timetable) {
        return timeTableService.save(timetable);
    }

    public List<Student> getStudentList(String subjectId) {
       List<StudentSubject> list = studentSubjectService.findAll();
       List<Student> studentList = new ArrayList<>();
       for (int i = 0; i < list.size(); i++)
       {
           if (list.get(i).getId().getSubjectId().equals(subjectId))
               studentList.add(list.get(i).getStudent());
       }

       return studentList;
    }

    public List<ClassSubject> getSubjectList(String studentId) {
        List<StudentSubject> list = studentSubjectService.findAll();
        List<ClassSubject> studentList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getStudent().getStudentId().equals(studentId))
                studentList.add(list.get(i).getClasssubject());
        }

        return studentList;
    }

    public boolean addStudentToSubject(String subjectId, Student student) {
        StudentSubjectId id = new StudentSubjectId(student.getStudentId(), subjectId);
        ClassSubject subject = subjectService.findOne(subjectId);

        return studentSubjectService.save(new StudentSubject(id,subject,student));
    }

    //TODO: Genius
    public boolean addStudentListToSubject(String subjectId, List<Student> studentList) {

        for (int i = 0; i < studentList.size(); i++) {
            addStudentToSubject(subjectId, studentList.get(i));
        }

       return true;
    }

    //TODO: Genius
    public boolean addStudentListToSubject(String subjectId, String csvPath) {
        /*
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
        */
        return false;
    }

    public List<Boolean> getCheckInData(String subjectId, String studentId)
    {
        List<Attendance> att = attendanceService.findAll();
        List<Boolean> res = new ArrayList<>();
        Date startDate = getSubjectStartDate(subjectId);

        for (int i = 0; i < 15; i++)
        {
            res.add(false);
        }

        for (int i = 0; i < att.size(); i++)
        {
            Attendance a = att.get(i);

            if (a.getId().getSubjectId().equals(subjectId) && a.getId().getStudentId().equals(studentId))
            {
                long diff = a.getId().getCheckInDate().getTime() - startDate.getTime();
                int weekDiff = (int)diff / (7*24 * 60 * 60 * 1000);

                if (weekDiff < 15)
                    res.set(weekDiff, true);
            }
        }

        return res;
    }

    public Date getSubjectStartDate(String subjectId)
    {
        List<Timetable> timetableList = timeTableService.findAll();

        for (int i = 0; i < timetableList.size(); i++)
        {
            if (timetableList.get(i).getClasssubject().getSubjectId().equals(subjectId))
            {
                return timetableList.get(i).getStartDate();
            }
        }

        return new Date();
    }

    public Map<Student,List<Boolean>> getCheckInDataBySubject(String subjectId)
    {
        List<Student> studentList = getStudentList(subjectId);
        Map<Student, List<Boolean>> data = new HashMap<>();

        for (int i = 0; i< studentList.size(); i++)
        {
            Student s = studentList.get(i);
            data.put(s, getCheckInData(subjectId, s.getStudentId()));
        }

        return data;
    }

    /**
     * Import a list of student from CSV file
     *
     * @param filePath     the string path of data file
     * @param isOverwriten flag to determine whether to overwrite the old data or not
     */
    private Set<Student> importFromCSV(String filePath, boolean isOverwriten, Set<Student> data) throws FileNotFoundException {
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
                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
                Date dob = formatter.parse(attr.get(5));
                String address = attr.get(6);
                Student s = new Student(studentId, studentName, usrName, className, sex, dob, address);
                data.add(s);
            } catch (Exception ex) {
                System.err.println(ex);
            }

        }
        scanner.close();

        return data;
    }
}

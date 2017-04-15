package main.java.model;
// Generated Apr 15, 2017 9:17:45 PM by Hibernate Tools 4.3.1


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Student generated by hbm2java
 */
public class Student extends BaseModel implements java.io.Serializable {


     private String studentId;
     private String studentName;
     private String usrName;
     private String className;
     private String sex;
     private Date dob;
     private String address;
     private Set studentSubjects = new HashSet(0);
     private Set attendances = new HashSet(0);

    public Student() {
    }

	
    public Student(String studentId) {
        this.studentId = studentId;
    }
    public Student(String studentId, String studentName, String usrName, String className, String sex, Date dob, String address, Set studentSubjects, Set attendances) {
       this.studentId = studentId;
       this.studentName = studentName;
       this.usrName = usrName;
       this.className = className;
       this.sex = sex;
       this.dob = dob;
       this.address = address;
       this.studentSubjects = studentSubjects;
       this.attendances = attendances;
    }

    public Student(String studentId, String studentName, String usrName, String className, String sex, Date dob, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.usrName = usrName;
        this.className = className;
        this.sex = sex;
        this.dob = dob;
        this.address = address;
    }
   
    public String getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return this.studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getUsrName() {
        return this.usrName;
    }
    
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public Set getStudentSubjects() {
        return this.studentSubjects;
    }
    
    public void setStudentSubjects(Set studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
    public Set getAttendances() {
        return this.attendances;
    }
    
    public void setAttendances(Set attendances) {
        this.attendances = attendances;
    }


    @Override
    public List<String> toStringList() {
        List<String> list = new ArrayList<>();
        list.add(studentId);
        list.add(studentName);
        list.add(usrName);
        list.add(className);
        list.add(sex);
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD");
        list.add(sf.format(dob));
        list.add(address);

        return list;
    }

}



package main.java;


import main.java.model.Student;
import main.java.service.user.StudentService;
import main.java.view.MainFrame;

import java.util.Date;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Genius Doan on 4/11/2017.
 */
public class Application {
    public static void main(final String[] args) throws Exception {


        StudentService s = new StudentService();
        List<Student> as = s.findAll();

        MainFrame mainFrame = new MainFrame("1412477 - Hibernate Assignment");
        mainFrame.setVisible(true);


    }
}
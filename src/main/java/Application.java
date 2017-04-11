package main.java;


import main.java.controller.user.StudentController;
import main.java.model.Student;
import main.java.utils.HibernateUtils;
import main.java.view.MainFrame;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;


/**
 * Created by Genius Doan on 4/11/2017.
 */
public class Application {
    public static void main(final String[] args) throws Exception {
        MainFrame mainFrame = new MainFrame("1412477 - Hibernate Assignment");
        mainFrame.setVisible(true);
    }
}
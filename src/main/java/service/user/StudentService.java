package main.java.service.user;

import main.java.model.Student;
import main.java.service.IBaseService;
import main.java.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class StudentService implements IBaseService<Student,Long> {
    @Override
    public Student findOne(Long aLong) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        List<Student> ds = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select std from Student std";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    @Override
    public List<Student> findAll(List<Long> listId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Student save(Student entity) {
        return null;
    }

    @Override
    public List<Student> save(List<Student> listEntity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public void delete(List<Student> listEntity) {

    }

    @Override
    public void deleteAll() {

    }
}

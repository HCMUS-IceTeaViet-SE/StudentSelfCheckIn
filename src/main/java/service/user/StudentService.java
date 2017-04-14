package main.java.service.user;

import main.java.model.Student;
import main.java.service.BaseService;
import main.java.service.IBaseService;
import main.java.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class StudentService extends BaseService implements IBaseService<Student,String> {
    @Override
    public Student findOne(String id) {
        Student s = null;
        Session session = HibernateUtils.getSession();
        try {
            s.getAddress();
            String hql = "select std from Student std where std.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            s = (Student) query.getSingleResult();
        } catch (HibernateException ex)
        {
            System.err.println(ex);
        }
        finally {
            session.close();
        }

        return s;
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
            System.err.println(ex.toString());
        } finally {
            session.close();
        }

        return ds;
    }

    @Override
    public List<Student> findAll(List<String> listId) {
        return null;
    }

    @Override
    public long count() {
        Long count = 0L;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select count(*) from Student";
            Query query = session.createQuery(hql);
            count = (Long) query.getSingleResult();
        } catch (HibernateException ex)
        {
            System.err.println(ex.toString());
        }
        return count;
    }

    @Override
    public boolean exists(String id) {
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
    public void delete(String id) {

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

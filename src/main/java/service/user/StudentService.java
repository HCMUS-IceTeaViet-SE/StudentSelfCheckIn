package main.java.service.user;

import main.java.model.Student;
import main.java.service.BaseService;
import main.java.service.IBaseService;
import main.java.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class StudentService extends BaseService implements IBaseService<Student, String> {
    @Override
    public Student findOne(String id) {
        //TODO: NoResourceException
        Student s = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select std from Student std where std.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            s = (Student) query.getSingleResult();
        } catch (PersistenceException ex) {
            System.err.println(ex);
        } finally {
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
        } catch (PersistenceException ex) {
            //Log the exception
            System.err.println(ex.toString());
        } finally {
            session.close();
        }

        return ds;
    }

    @Override
    public List<Student> findAll(List<String> listId) {
        List<Student> res = new ArrayList<>();

        for (int i = 0; i < listId.size(); i++) {
            Student s = findOne(listId.get(i));
            if (s != null)
                res.add(s);
        }

        return res;
    }

    @Override
    public long count() {
        Long count = 0L;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select count(*) from Student";
            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
        return count;
    }

    @Override
    public boolean exists(String id) {
        //If found a student -> exist
        return findOne(id) != null;
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public boolean update(List<Student> listEntity) {
        return false;
    }


    @Override
    public boolean save(Student student) {
        Session session = HibernateUtils.getSession();
        if (exists(student.getStudentId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (PersistenceException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean save(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            try {
                if (studentList.get(i) != null)
                    save(studentList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public void delete(String id) {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from Student std where std = \'" + id + "\'";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }


    @Override
    public void delete(Student entity) {
        delete(entity.getStudentId());
    }

    @Override
    public void delete(List<Student> listEntity) {
        for (int i = 0; i < listEntity.size(); i++) {
            delete(listEntity.get(i).getStudentId());
        }
    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from Student";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }
}

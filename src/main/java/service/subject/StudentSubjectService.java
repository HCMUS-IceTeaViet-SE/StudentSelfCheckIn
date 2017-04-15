package main.java.service.subject;

import main.java.model.*;
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
 * Created by Genius Doan on 4/15/2017.
 */
public class StudentSubjectService  extends BaseService implements IBaseService<StudentSubject, StudentSubjectId> {
    @Override
    public StudentSubject findOne(StudentSubjectId id) {
        StudentSubject att = null;
        Session session = HibernateUtils.getSession();
        try {
            /*
            String hql = "select att from StudentSubject att where att.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            att = (StudentSubject) query.getSingleResult();
            */
            session.get(StudentSubject.class, id);
        } catch (PersistenceException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return att;
    }

    @Override
    public List<StudentSubject> findAll() {
        List<StudentSubject> ds = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select att from StudentSubject att";
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
    public List<StudentSubject> findAll(List<StudentSubjectId> listId) {
        List<StudentSubject> res = new ArrayList<>();

        for (int i = 0; i < listId.size(); i++) {
            StudentSubject att = findOne(listId.get(i));
            if (att != null)
                res.add(att);
        }

        return res;
    }

    @Override
    public long count() {
        Long count = 0L;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select count(*) from StudentSubject";
            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
        return count;
    }

    @Override
    public boolean exists(StudentSubjectId id) {
        return findOne(id) != null;
    }

    @Override
    public boolean update(StudentSubject studentSubject) {
        Session session = HibernateUtils.getSession();
        if (!exists(studentSubject.getId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(studentSubject);
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
    public boolean update(List<StudentSubject> studentSubjectList) {
        for (int i = 0; i < studentSubjectList.size(); i++) {
            try {
                if (studentSubjectList.get(i) != null)
                    update(studentSubjectList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean save(StudentSubject studentSubject) {
        Session session = HibernateUtils.getSession();
        if (exists(studentSubject.getId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(studentSubject);
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
    public boolean save(List<StudentSubject> studentSubjectList) {
        for (int i = 0; i < studentSubjectList.size(); i++) {
            try {
                if (studentSubjectList.get(i) != null)
                    save(studentSubjectList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public void delete(StudentSubjectId id) {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from StudentSubject att where att = \'" + id + "\'";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(StudentSubject entity) {
        delete(entity.getId());
    }

    @Override
    public void delete(List<StudentSubject> listEntity) {
        for (int i = 0; i < listEntity.size(); i++) {
            delete(listEntity.get(i).getId());
        }
    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from StudentSubject";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }
}
    
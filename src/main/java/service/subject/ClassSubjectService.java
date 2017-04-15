package main.java.service.subject;

import main.java.model.ClassSubject;
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
 * Created by Genius Doan on 4/12/2017.
 */
public class ClassSubjectService extends BaseService implements IBaseService<ClassSubject, String> {
    @Override
    public ClassSubject findOne(String id) {
        ClassSubject classSubject = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from ClassSubject t where t.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            classSubject = (ClassSubject) query.getSingleResult();
        } catch (PersistenceException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return classSubject;
    }

    @Override
    public List<ClassSubject> findAll() {
        List<ClassSubject> classSubjectList = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from ClassSubject t";
            Query query = session.createQuery(hql);
            classSubjectList = query.list();
        } catch (PersistenceException ex) {
            //Log the exception
            System.err.println(ex.toString());
        } finally {
            session.close();
        }

        return classSubjectList;
    }

    @Override
    public List<ClassSubject> findAll(List<String> listId) {
        List<ClassSubject> res = new ArrayList<>();

        for (int i = 0; i < listId.size(); i++) {
            ClassSubject classSubject = findOne(listId.get(i));
            if (classSubject != null)
                res.add(classSubject);
        }

        return res;
    }

    @Override
    public long count() {
        Long count = 0L;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select count(*) from ClassSubject";
            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
        return count;
    }

    @Override
    public boolean exists(String id) {
        return findOne(id) != null;
    }

    @Override
    public boolean update(ClassSubject classSubject) {
        Session session = HibernateUtils.getSession();
        if (!exists(classSubject.getSubjectId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(classSubject);
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
    public boolean update(List<ClassSubject> classSubjectList) {
        for (int i = 0; i < classSubjectList.size(); i++) {
            try {
                if (classSubjectList.get(i) != null)
                    update(classSubjectList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean save(ClassSubject classSubject) {
        Session session = HibernateUtils.getSession();
        if (exists(classSubject.getSubjectId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(classSubject);
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
    public boolean save(List<ClassSubject> classSubjectList) {
        for (int i = 0; i < classSubjectList.size(); i++) {
            try {
                if (classSubjectList.get(i) != null)
                    save(classSubjectList.get(i));
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
            String hql = "delete from ClassSubject t where t = \'" + id + "\'";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(ClassSubject entity) {
        delete(entity.getSubjectId());
    }

    @Override
    public void delete(List<ClassSubject> listEntity) {
        for (int i = 0; i < listEntity.size(); i++) {
            delete(listEntity.get(i).getSubjectId());
        }
    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from ClassSubject";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }
}

package main.java.service.user;

import main.java.model.Teacher;
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
public class TeacherService extends BaseService implements IBaseService<Teacher, String> {

    @Override
    public Teacher findOne(String id) {
        Teacher teacher = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from Teacher t where t.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            teacher = (Teacher) query.getSingleResult();
        } catch (PersistenceException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return teacher;
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teacherList = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from Teacher t";
            Query query = session.createQuery(hql);
            teacherList = query.list();
        } catch (PersistenceException ex) {
            //Log the exception
            System.err.println(ex.toString());
        } finally {
            session.close();
        }

        return teacherList;
    }

    @Override
    public List<Teacher> findAll(List<String> listId) {
        List<Teacher> res = new ArrayList<>();

        for (int i = 0; i < listId.size(); i++) {
            Teacher teacher = findOne(listId.get(i));
            if (teacher != null)
                res.add(teacher);
        }

        return res;
    }

    @Override
    public long count() {
        Long count = 0L;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select count(*) from Teacher";
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
    public boolean update(Teacher teacher) {
        Session session = HibernateUtils.getSession();
        if (!exists(teacher.getTeacherId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(teacher);
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
    public boolean update(List<Teacher> teacherList) {
        for (int i = 0; i < teacherList.size(); i++) {
            try {
                if (teacherList.get(i) != null)
                    update(teacherList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean save(Teacher teacher) {
        Session session = HibernateUtils.getSession();
        if (exists(teacher.getTeacherId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(teacher);
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
    public boolean save(List<Teacher> teacherList) {
        for (int i = 0; i < teacherList.size(); i++) {
            try {
                if (teacherList.get(i) != null)
                    save(teacherList.get(i));
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
            String hql = "delete from Teacher t where t = \'" + id + "\'";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(Teacher entity) {
        delete(entity.getTeacherId());
    }

    @Override
    public void delete(List<Teacher> listEntity) {
        for (int i = 0; i < listEntity.size(); i++) {
            delete(listEntity.get(i).getTeacherId());
        }
    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from Teacher";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }
}

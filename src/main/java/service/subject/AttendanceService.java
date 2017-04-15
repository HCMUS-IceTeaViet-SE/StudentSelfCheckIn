package main.java.service.subject;

import main.java.model.Attendance;
import main.java.model.AttendanceId;
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
public class AttendanceService extends BaseService implements IBaseService<Attendance, AttendanceId> {
    @Override
    public Attendance findOne(AttendanceId id) {
        Attendance att = null;
        Session session = HibernateUtils.getSession();
        try {
            /*
            String hql = "select att from Attendance att where att.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            att = (Attendance) query.getSingleResult();
            */
            session.get(Attendance.class, id);
        } catch (PersistenceException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return att;
    }

    @Override
    public List<Attendance> findAll() {
        List<Attendance> ds = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select att from Attendance att";
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
    public List<Attendance> findAll(List<AttendanceId> listId) {
        List<Attendance> res = new ArrayList<>();

        for (int i = 0; i < listId.size(); i++) {
            Attendance att = findOne(listId.get(i));
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
            String hql = "select count(*) from Attendance ";
            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
        return count;
    }

    @Override
    public boolean exists(AttendanceId id) {
        return findOne(id) != null;
    }

    @Override
    public boolean update(Attendance attendance) {
        Session session = HibernateUtils.getSession();
        if (!exists(attendance.getId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(attendance);
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
    public boolean update(List<Attendance> attendanceList) {
        for (int i = 0; i < attendanceList.size(); i++) {
            try {
                if (attendanceList.get(i) != null)
                    update(attendanceList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean save(Attendance attendance) {
        Session session = HibernateUtils.getSession();
        if (exists(attendance.getId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(attendance);
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
    public boolean save(List<Attendance> attendanceList) {
        for (int i = 0; i < attendanceList.size(); i++) {
            try {
                if (attendanceList.get(i) != null)
                    save(attendanceList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public void delete(AttendanceId id) {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from Attendance att where att = \'" + id + "\'";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(Attendance entity) {
        delete(entity.getId());
    }

    @Override
    public void delete(List<Attendance> listEntity) {
        for (int i = 0; i < listEntity.size(); i++) {
            delete(listEntity.get(i).getId());
        }
    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from Attendance";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }
}

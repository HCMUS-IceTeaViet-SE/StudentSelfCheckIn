package main.java.service.subject;

import main.java.model.Timetable;
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
public class TimeTableService extends BaseService implements IBaseService<Timetable, String> {
    @Override
    public Timetable findOne(String id) {
        Timetable timeTable = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from Timetable t where t.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            timeTable = (Timetable) query.getSingleResult();
        } catch (PersistenceException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return timeTable;
    }

    @Override
    public List<Timetable> findAll() {
        List<Timetable> timeTableList = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from Timetable t";
            Query query = session.createQuery(hql);
            timeTableList = query.list();
        } catch (PersistenceException ex) {
            //Log the exception
            System.err.println(ex.toString());
        } finally {
            session.close();
        }

        return timeTableList;
    }

    @Override
    public List<Timetable> findAll(List<String> listId) {
        List<Timetable> res = new ArrayList<>();

        for (int i = 0; i < listId.size(); i++) {
            Timetable timeTable = findOne(listId.get(i));
            if (timeTable != null)
                res.add(timeTable);
        }

        return res;
    }

    @Override
    public long count() {
        Long count = 0L;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select count(*) from Timetable";
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
    public boolean update(Timetable timeTable) {
        Session session = HibernateUtils.getSession();
        if (!exists(timeTable.getTimeTableId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(timeTable);
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
    public boolean update(List<Timetable> timeTableList) {
        for (int i = 0; i < timeTableList.size(); i++) {
            try {
                if (timeTableList.get(i) != null)
                    update(timeTableList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean save(Timetable timeTable) {
        Session session = HibernateUtils.getSession();
        if (exists(timeTable.getTimeTableId())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(timeTable);
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
    public boolean save(List<Timetable> timeTableList) {
        for (int i = 0; i < timeTableList.size(); i++) {
            try {
                if (timeTableList.get(i) != null)
                    save(timeTableList.get(i));
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
            String hql = "delete from Timetable t where t = \'" + id + "\'";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(Timetable entity) {
        delete(entity.getTimeTableId());
    }

    @Override
    public void delete(List<Timetable> listEntity) {
        for (int i = 0; i < listEntity.size(); i++) {
            delete(listEntity.get(i).getTimeTableId());
        }
    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from Timetable";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }
}

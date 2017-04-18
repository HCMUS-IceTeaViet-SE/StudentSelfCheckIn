package main.java.service.school;

import main.java.model.Account;
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
public class AccountService extends BaseService implements IBaseService<Account, String> {
    @Override
    public Account findOne(String id) {
        Account acc = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from Account t where t.id = \'" + id + "\'";
            Query query = session.createQuery(hql);
            acc = (Account) query.getSingleResult();
        } catch (PersistenceException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return acc;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accountList = null;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select t from Account t";
            Query query = session.createQuery(hql);
            accountList = query.list();
        } catch (PersistenceException ex) {
            //Log the exception
            System.err.println(ex.toString());
        } finally {
            session.close();
        }

        return accountList;
    }

    @Override
    public List<Account> findAll(List<String> listId) {
        List<Account> res = new ArrayList<>();

        for (int i = 0; i < listId.size(); i++) {
            Account acc = findOne(listId.get(i));
            if (acc != null)
                res.add(acc);
        }

        return res;
    }

    @Override
    public long count() {
        Long count = 0L;
        Session session = HibernateUtils.getSession();
        try {
            String hql = "select count(*) from Account";
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
    public boolean update(Account acc) {
        Session session = HibernateUtils.getSession();
        if (!exists(acc.getUsrName())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(acc);
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
    public boolean update(List<Account> accountList) {
        for (int i = 0; i < accountList.size(); i++) {
            try {
                if (accountList.get(i) != null)
                    update(accountList.get(i));
            } catch (Exception ex) {
                System.err.println(ex);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean save(Account acc) {
        Session session = HibernateUtils.getSession();
        if (exists(acc.getUsrName())) {
            //Already in table
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(acc);
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
    public boolean save(List<Account> accountList) {
        for (int i = 0; i < accountList.size(); i++) {
            try {
                if (accountList.get(i) != null)
                    save(accountList.get(i));
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
            String hql = "delete from Account t where t = \'" + id + "\'";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(Account entity) {
        delete(entity.getUsrName());
    }

    @Override
    public void delete(List<Account> listEntity) {
        for (int i = 0; i < listEntity.size(); i++) {
            delete(listEntity.get(i).getUsrName());
        }
    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "delete from Account";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (PersistenceException ex) {
            System.err.println(ex.toString());
        }
    }
}

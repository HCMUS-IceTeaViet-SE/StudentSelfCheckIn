package main.java.service.school;

import main.java.model.Account;
import main.java.service.BaseService;
import main.java.service.IBaseService;

import java.util.List;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class AccountService extends BaseService implements IBaseService<Account, String> {
    @Override
    public Account findOne(String userName) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public List<Account> findAll(List<String> listId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(String userName) {
        return false;
    }

    @Override
    public boolean update(Account entity) {
        return false;
    }

    @Override
    public boolean update(List<Account> listEntity) {
        return false;
    }

    @Override
    public boolean save(Account entity) {
        return false;
    }

    @Override
    public boolean save(List<Account> listEntity) {
        return false;
    }

    @Override
    public void delete(String userName) {

    }

    @Override
    public void delete(Account entity) {

    }

    @Override
    public void delete(List<Account> listEntity) {

    }

    @Override
    public void deleteAll() {

    }
}

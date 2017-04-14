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
    public Account save(Account entity) {
        return null;
    }

    @Override
    public List<Account> save(List<Account> listEntity) {
        return null;
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

package main.java.service.user;

import main.java.model.Teacher;
import main.java.service.BaseService;
import main.java.service.IBaseService;

import java.util.List;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class TeacherService extends BaseService implements IBaseService<Teacher, String> {

    @Override
    public Teacher findOne(String id) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public List<Teacher> findAll(List<String> listId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public Teacher save(Teacher entity) {
        return null;
    }

    @Override
    public List<Teacher> save(List<Teacher> listEntity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(Teacher entity) {

    }

    @Override
    public void delete(List<Teacher> listEntity) {

    }

    @Override
    public void deleteAll() {

    }
}

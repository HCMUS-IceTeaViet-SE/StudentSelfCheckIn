package main.java.service.user;

import main.java.model.Teacher;
import main.java.service.IBaseService;

import java.util.List;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class TeacherService implements IBaseService<Teacher, Long> {
    @Override
    public Teacher findOne(Long aLong) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public List<Teacher> findAll(List<Long> listId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(Long aLong) {
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
    public void delete(Long aLong) {

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

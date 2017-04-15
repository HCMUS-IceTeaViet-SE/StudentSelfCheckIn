package main.java.service.subject;

import main.java.model.ClassSubject;
import main.java.service.BaseService;
import main.java.service.IBaseService;

import java.util.List;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class ClassSubjectService extends BaseService implements IBaseService<ClassSubject, String> {
    @Override
    public ClassSubject findOne(String id) {
        return null;
    }

    @Override
    public List<ClassSubject> findAll() {
        return null;
    }

    @Override
    public List<ClassSubject> findAll(List<String> listId) {
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
    public boolean update(ClassSubject entity) {
        return false;
    }

    @Override
    public boolean update(List<ClassSubject> listEntity) {
        return false;
    }

    @Override
    public boolean save(ClassSubject entity) {
        return false;
    }

    @Override
    public boolean save(List<ClassSubject> listEntity) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(ClassSubject entity) {

    }

    @Override
    public void delete(List<ClassSubject> listEntity) {

    }

    @Override
    public void deleteAll() {

    }
}

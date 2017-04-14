package main.java.service.subject;

import main.java.model.Timetable;
import main.java.service.BaseService;
import main.java.service.IBaseService;

import java.util.List;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class TimeTableService extends BaseService implements IBaseService<Timetable, String> {
    @Override
    public Timetable findOne(String id) {
        return null;
    }

    @Override
    public List<Timetable> findAll() {
        return null;
    }

    @Override
    public List<Timetable> findAll(List<String> listId) {
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
    public Timetable save(Timetable entity) {
        return null;
    }

    @Override
    public List<Timetable> save(List<Timetable> listEntity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(Timetable entity) {

    }

    @Override
    public void delete(List<Timetable> listEntity) {

    }

    @Override
    public void deleteAll() {

    }
}

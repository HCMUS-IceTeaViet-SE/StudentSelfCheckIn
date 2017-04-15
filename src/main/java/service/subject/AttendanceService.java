package main.java.service.subject;

import main.java.model.Attendance;
import main.java.model.AttendanceId;
import main.java.service.BaseService;
import main.java.service.IBaseService;

import java.util.List;

/**
 * Created by Genius Doan on 4/12/2017.
 */
public class AttendanceService extends BaseService implements IBaseService<Attendance, AttendanceId> {
    @Override
    public Attendance findOne(AttendanceId id) {
        return null;
    }

    @Override
    public List<Attendance> findAll() {
        return null;
    }

    @Override
    public List<Attendance> findAll(List<AttendanceId> listId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(AttendanceId id) {
        return false;
    }

    @Override
    public boolean update(Attendance entity) {
        return false;
    }

    @Override
    public boolean update(List<Attendance> listEntity) {
        return false;
    }

    @Override
    public boolean save(Attendance entity) {
        return false;
    }

    @Override
    public boolean save(List<Attendance> listEntity) {
        return false;
    }

    @Override
    public void delete(AttendanceId id) {

    }

    @Override
    public void delete(Attendance entity) {

    }

    @Override
    public void delete(List<Attendance> listEntity) {

    }

    @Override
    public void deleteAll() {

    }
}

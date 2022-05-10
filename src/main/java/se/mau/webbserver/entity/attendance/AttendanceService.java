package se.mau.webbserver.entity.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.activity.ActivityService;

import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository repository;

    @Autowired
    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public Attendance getAttendance(Long id) {
        Optional<Attendance> optionalAttendance = repository.findById(id);

        if(optionalAttendance.isPresent()) {
            return optionalAttendance.get();
        } else {
            throw new IllegalStateException(String.format("Attendance with id %s does not exist.", id));
        }
    }

    public void addAttendance(Attendance attendance) {
        Optional<Attendance> optionalActivity = repository.findById(attendance.getId());

        if(optionalActivity.isPresent()) {
            throw new IllegalStateException(String.format("Activity with %s already exists.", attendance.getId()));
        }
        repository.save(attendance);
    }
}

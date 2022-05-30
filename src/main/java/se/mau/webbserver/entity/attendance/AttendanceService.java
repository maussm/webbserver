package se.mau.webbserver.entity.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final CostCenterRepository costCenterRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository, CostCenterRepository costCenterRepository) {
        this.attendanceRepository = attendanceRepository;
        this.costCenterRepository = costCenterRepository;
    }

    public List<Attendance> getAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendance(Integer id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if(optionalAttendance.isPresent()) {
            return optionalAttendance.get();
        } else {
            throw new IllegalStateException(String.format("Attendance with id %s does not exist.", id));
        }
    }

    public void addAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Integer id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if(optionalAttendance.isEmpty()) {
            throw new IllegalStateException(String.format("Attendance with id %s does not exist.", id));
        }

        attendanceRepository.delete(optionalAttendance.get());
    }

    public void patchAttendance(Integer id, Attendance attendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if (optionalAttendance.isEmpty()) {
            throw new IllegalStateException(String.format("Attendance with id %s does not exist.", id));
        }

        Attendance _attendance = optionalAttendance.get();

        if (attendance.getDate() != null) {
            _attendance.setDate(attendance.getDate());
        }
        if (attendance.getParticipant() != null) {
            _attendance.setParticipant(attendance.getParticipant());
        }
        if (attendance.getC().getId() != null) {
            int costCenterId = attendance.getC().getId();
            Optional<CostCenter> costCenter = costCenterRepository.findById(costCenterId);

            if (costCenter.isEmpty()) {
                throw new IllegalStateException("Cost center was not found.");
            }

            _attendance.setC(costCenter.get());
        }
        attendanceRepository.save(_attendance);
    }
}

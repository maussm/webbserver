package se.mau.webbserver.entity.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterRepository;

import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen attendance.
 */
@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final CostCenterRepository costCenterRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param attendanceRepository Kopplingen mot tabellen attendance.
     * @param costCenterRepository Kopplingen mot tabellen cost_center.
     */
    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository, CostCenterRepository costCenterRepository) {
        this.attendanceRepository = attendanceRepository;
        this.costCenterRepository = costCenterRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av Attendance med alla rader som finns.
     */
    public List<Attendance> getAttendances() {
        return attendanceRepository.findAll();
    }

    /**
     * Hämtar ActivityContents med ett visst id.
     * @param id Id som ska sökas på i databasen.
     * @return ActivityContents om den finnas, annars kastas ett felmeddelande.
     */
    public Attendance getAttendance(Integer id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if(optionalAttendance.isPresent()) {
            return optionalAttendance.get();
        } else {
            throw new IllegalStateException(String.format("Attendance with id %s does not exist.", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param attendance Datan som ska läggas till.
     */
    public void addAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    /**
     * Tar bort data med ett specifikt id från databasen.
     * @param id Id på den data som ska tas bort.
     */
    public void deleteAttendance(Integer id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if(optionalAttendance.isEmpty()) {
            throw new IllegalStateException(String.format("Attendance with id %s does not exist.", id));
        }

        attendanceRepository.delete(optionalAttendance.get());
    }

    /**
     * Uppdaterar data i databasen.
     * @param id Id på den data som ska uppdateras.
     * @param attendance Uppdaterade datan som ska sparas i databasen.
     */
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

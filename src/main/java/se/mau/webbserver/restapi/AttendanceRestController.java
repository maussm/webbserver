package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.attendance.Attendance;
import se.mau.webbserver.entity.attendance.AttendanceDTO;
import se.mau.webbserver.entity.attendance.AttendanceService;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import se.mau.webbserver.entity.participant.Participant;
import se.mau.webbserver.entity.participant.ParticipantService;

import java.util.List;

/**
 * REST API klass för tabellen attendance.
 */
@RestController
@RequestMapping("/api/attendance")
public class AttendanceRestController {

    private final AttendanceService attendanceService;
    private final ParticipantService participantService;
    private final CostCenterService costCenterService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param attendanceService Koppling mot tabellen attendance.
     * @param participantService Koppling mot tabellen participant.
     * @param costCenterService Koppling mot tabellen cost_center.
     */
    @Autowired
    public AttendanceRestController(AttendanceService attendanceService, ParticipantService participantService, CostCenterService costCenterService) {
        this.attendanceService = attendanceService;
        this.participantService = participantService;
        this.costCenterService = costCenterService;
    }

    /**
     * URI: /api/attendance
     * METOD: GET
     * Hämtar alla Attendance.
     * @return Alla Attendance som finns.
     */
    @GetMapping
    public List<Attendance> getAttendances() {
        return attendanceService.getAttendances();
    }

    /**
     * URI: /api/attendance/{id}
     * METOD: GET
     * Hämtar en Attendance med angivet id.
     * @param id Id på attendance.
     * @return En Attendance med angivet id.
     */
    @GetMapping("/{id}")
    public Attendance getAttendance(@PathVariable Integer id) {
        return attendanceService.getAttendance(id);
    }

    /**
     * URI: /api/attendance
     * METOD: POST
     * Tar emot ett objekt i JSON format och bygger upp en Attendance som sedan sparas i databasen.
     * @param attendanceDTO Det objekt som ska läggs till i databasen.
     */
    @PostMapping
    public void addAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        Participant participant = participantService.getParticipant(attendanceDTO.getParticipant_id());
        CostCenter costCenter = costCenterService.getCostCenter(attendanceDTO.getCost_center_id());

        Attendance attendance = new Attendance();
        attendance.setDate(attendanceDTO.getDate());
        attendance.setParticipant(participant);
        attendance.setC(costCenter);

        attendanceService.addAttendance(attendance);

    }

    /**
     * URI: /api/attendance/{id}
     * METOD: DELETE
     * Tar bort en Attendance från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Integer id) {
        attendanceService.deleteAttendance(id);
    }

    /**
     * URI: /api/attendance/{id}
     * METOD: PATCH
     * Uppdaterar en Attendance i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchAttendance(@PathVariable Integer id, @RequestBody Attendance attendance) {
        attendanceService.patchAttendance(id, attendance);
    }
}

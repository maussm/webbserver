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
import se.mau.webbserver.entity.attendance.AttendanceService;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceRestController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceRestController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<Attendance> getAttendances() {
        return attendanceService.getAttendances();
    }
    @GetMapping("/{id}")
    public Attendance getAttendance(@PathVariable Integer id) {
        return attendanceService.getAttendance(id);
    }

    @PostMapping
    public void addAttendance(@RequestBody Attendance attendance) {
        attendanceService.addAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Integer id) {
        attendanceService.deleteAttendance(id);
    }

    @PatchMapping("/{id}")
    public void patchAttendance(@PathVariable Integer id, @RequestBody Attendance attendance) {
        attendanceService.patchAttendance(id, attendance);
    }
}

package se.mau.webbserver.entity.attendance;

import java.time.LocalDate;

public class AttendanceDTO {
    private Integer participant_id;
    private Integer cost_center_id;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }

    public Integer getCost_center_id() {
        return cost_center_id;
    }

    public void setCost_center_id(Integer cost_center_id) {
        this.cost_center_id = cost_center_id;
    }
}

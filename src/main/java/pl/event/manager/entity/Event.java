package pl.event.manager.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long id;
    @Column(name = "event_name", nullable = false)
    private String eventName;
    @Column(name = "event_start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "event_end_date", nullable = false)
    private LocalDateTime endDate;
    @Column(name = "event_description", nullable = false)
    private String eventDescription;
    @Column(name = "user_who_added_id", nullable = false)
    private long userWhoAddedId;

    public Event() {
    }

    public Event(long id, String eventName, LocalDateTime startDate, LocalDateTime endDate, String eventDescription, long userWhoAddedId) {
        this.id = id;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventDescription = eventDescription;
        this.userWhoAddedId = userWhoAddedId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public long getUserWhoAddedId() {
        return userWhoAddedId;
    }

    public void setUserWhoAddedId(long userWhoAddedId) {
        this.userWhoAddedId = userWhoAddedId;
    }
}

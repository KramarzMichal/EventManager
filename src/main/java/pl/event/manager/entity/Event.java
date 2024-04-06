package pl.event.manager.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    @ElementCollection
    @CollectionTable(name = "event_participants", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "event_participants", nullable = false)
    private List<Long> eventParticipants;
    @ElementCollection
    @CollectionTable(name = "comments", joinColumns = @JoinColumn(name = "comment_id"))
    @Column(name = "event_comments", nullable = false)
    private List<Long> eventComments;


    public Event() {
    }
    public Event(long id, String eventName, LocalDateTime startDate, LocalDateTime endDate, String eventDescription, long userWhoAddedId, List<Long> eventParticipants, List<Long> eventComments) {
        this.id = id;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventDescription = eventDescription;
        this.userWhoAddedId = userWhoAddedId;
        this.eventParticipants = eventParticipants;
        this.eventComments = eventComments;
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

    public List<Long> getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(List<Long> eventParticipants) {
        this.eventParticipants = eventParticipants;
    }

    public List<Long> getEventComments() {
        return eventComments;
    }

    public void setEventComments(List<Long> eventComments) {
        this.eventComments = eventComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return id == event.id && userWhoAddedId == event.userWhoAddedId && Objects.equals(eventName, event.eventName) && Objects.equals(startDate, event.startDate) && Objects.equals(endDate, event.endDate) && Objects.equals(eventDescription, event.eventDescription) && Objects.equals(eventParticipants, event.eventParticipants) && Objects.equals(eventComments, event.eventComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, startDate, endDate, eventDescription, userWhoAddedId, eventParticipants, eventComments);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", eventDescription='" + eventDescription + '\'' +
                ", userWhoAddedId=" + userWhoAddedId +
                ", eventParticipants=" + eventParticipants +
                ", eventComments=" + eventComments +
                '}';
    }
}

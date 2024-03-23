package pl.event.manager.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;
    @Column
    private String comment;

    public Comment(long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment1)) return false;
        return id == comment1.id && Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment);
    }

}


package pl.event.manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String authority;
}

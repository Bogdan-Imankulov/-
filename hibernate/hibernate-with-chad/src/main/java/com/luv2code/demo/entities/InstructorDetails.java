package com.luv2code.demo.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instructor_details")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "youtube_channel", length = 45)
    private String youtubeChannel;

    @Column(name = "hobby", length = 45)
    private String hobby;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InstructorDetails that = (InstructorDetails) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
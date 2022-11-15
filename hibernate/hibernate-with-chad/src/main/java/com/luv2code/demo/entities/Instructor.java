package com.luv2code.demo.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@RequiredArgsConstructor
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "first_name", length = 45)
	private String firstName;

	@Column(name = "last_name", length = 45)
	private String lastName;

	@Column(name = "email", length = 45)
	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Instructor_detail_id")
	private InstructorDetails instructorDetail;

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Instructor that = (Instructor) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"firstName = " + firstName + ", " +
				"lastName = " + lastName + ", " +
				"email = " + email + ")";
	}
}
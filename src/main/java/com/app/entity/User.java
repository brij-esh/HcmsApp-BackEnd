package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString(exclude = "slots")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userFirstName;
	private String userLastName;
	private int userAge;
	private String userPhone;
	private String userEmailId;
	private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-ref")
    private List<Slot> slots;
}

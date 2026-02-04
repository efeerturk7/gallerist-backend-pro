package com.efeerturk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "gallerist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gallerist extends BaseEntity{


	private String firstName;

	private String lastName;
	
	@OneToOne
	private Address address;
	
}

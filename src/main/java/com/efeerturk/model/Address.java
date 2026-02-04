package com.efeerturk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity{


	private String city;
	

	private String district;
	

	private String neighborhood;
	

	private String street;
	
	
	
	
	
	
}

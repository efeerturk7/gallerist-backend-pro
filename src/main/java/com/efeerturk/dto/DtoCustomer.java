package com.efeerturk.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoCustomer extends DtoBase{

	private String firstName;
	
	private String lastName;
	
	private String tckn;
	
	private Date birthOfDate;
	
	private DtoAddress address;
	
	private DtoAccount  account;
}

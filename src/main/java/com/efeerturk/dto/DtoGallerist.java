package com.efeerturk.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoGallerist extends DtoBase {

	private String firstName;

	private String lastName;

	private DtoAddress address;
}

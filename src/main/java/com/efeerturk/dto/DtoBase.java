package com.efeerturk.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoBase {

	private Long id;
	
	private Date createTime;
}

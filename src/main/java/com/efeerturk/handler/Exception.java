package com.efeerturk.handler;

import java.util.Date;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E> {

	private String path;
	
	private Date createTime;
	
	private String hostName;
	
	private E message;
}

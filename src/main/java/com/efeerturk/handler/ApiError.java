package com.efeerturk.handler;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<E> {

	private Integer status;
	
	private Exception<E> exception;
}

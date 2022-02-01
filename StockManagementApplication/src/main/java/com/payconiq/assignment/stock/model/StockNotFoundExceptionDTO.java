package com.payconiq.assignment.stock.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Exception DTO class for the custom Exception of the application
 * @author rtbrt2009@gmail.com
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockNotFoundExceptionDTO {

	private String code;
	private HttpStatus status;
	private String message;
}

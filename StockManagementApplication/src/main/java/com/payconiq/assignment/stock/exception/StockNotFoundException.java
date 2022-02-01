package com.payconiq.assignment.stock.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Custom exception class of the application
 *@author rtbrt2009@gmail.com
 */

@AllArgsConstructor
@Getter
@Setter
public class StockNotFoundException extends RuntimeException{
	
	String code;
    HttpStatus status;
    String message;

}

package com.payconiq.assignment.stock.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum to initialize and define the custom error of the application
 *@author rtbrt2009@gmail.com
 */

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StockErrorDetails {

	STOCK_APPLICATION_INVALID_METHOD_ERROR("TPA-0001", HttpStatus.METHOD_NOT_ALLOWED, "Invalid method error"),
	STOCK_APPLICATION_BAD_REQUEST_ERROR("TPA-0002", HttpStatus.BAD_REQUEST, "Bad request error"),
	STOCK_NOT_FOUND_EXCEPTION("TPA-0003", HttpStatus.NOT_FOUND, "Invalid request exception");
	
	private final String code;
	private final HttpStatus status;
    private final String message;
}

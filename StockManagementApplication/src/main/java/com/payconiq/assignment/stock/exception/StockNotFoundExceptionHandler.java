package com.payconiq.assignment.stock.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payconiq.assignment.stock.model.StockNotFoundExceptionDTO;

/**
 * Custom exception handler class of the application
 *@author rtbrt2009@gmail.com
 */

@RestControllerAdvice
public class StockNotFoundExceptionHandler {
	
	@ExceptionHandler(StockNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public StockNotFoundExceptionDTO handleStockNotFoundException(StockNotFoundException ex) {
		return new StockNotFoundExceptionDTO(ex.code, ex.status, ex.getMessage());
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public StockNotFoundExceptionDTO handleInvalidRequestMethodException(HttpRequestMethodNotSupportedException ex) {
		return new StockNotFoundExceptionDTO(StockErrorDetails.STOCK_APPLICATION_INVALID_METHOD_ERROR.getCode(),
				StockErrorDetails.STOCK_APPLICATION_INVALID_METHOD_ERROR.getStatus(),
				StockErrorDetails.STOCK_APPLICATION_INVALID_METHOD_ERROR.getMessage());
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public StockNotFoundExceptionDTO handleBadRequestMethodException(MissingServletRequestParameterException ex) {
		return new StockNotFoundExceptionDTO(StockErrorDetails.STOCK_APPLICATION_BAD_REQUEST_ERROR.getCode(),
				StockErrorDetails.STOCK_APPLICATION_BAD_REQUEST_ERROR.getStatus(),
				StockErrorDetails.STOCK_APPLICATION_BAD_REQUEST_ERROR.getMessage());
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public StockNotFoundExceptionDTO handleInternalServerError(EmptyResultDataAccessException ex) {
		return new StockNotFoundExceptionDTO(StockErrorDetails.STOCK_NOT_FOUND_EXCEPTION.getCode(),
				StockErrorDetails.STOCK_NOT_FOUND_EXCEPTION.getStatus(),
				StockErrorDetails.STOCK_NOT_FOUND_EXCEPTION.getMessage());
	}

}

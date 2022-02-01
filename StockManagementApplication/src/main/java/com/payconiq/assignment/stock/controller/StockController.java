package com.payconiq.assignment.stock.controller;

import static com.payconiq.assignment.stock.config.ApplicationEndPoints.API;
import static com.payconiq.assignment.stock.config.ApplicationEndPoints.DELETE_STOCK_BY_ID_ENDPOINT;
import static com.payconiq.assignment.stock.config.ApplicationEndPoints.GET_STOCKS_ENDPOINT;
import static com.payconiq.assignment.stock.config.ApplicationEndPoints.GET_STOCK_BY_ID_ENDPOINT;
import static com.payconiq.assignment.stock.config.ApplicationEndPoints.SAVE_STOCK_ENDPOINT;
import static com.payconiq.assignment.stock.config.ApplicationEndPoints.UPDATE_STOCK_ENDPOINT;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.assignment.stock.Service.StockService;
import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.model.StockDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


/**
 * The Stock controller for the application which defines the end points.
 * @author rtbrt2009@gmail.com
 *
 */

@RestController
@RequestMapping(value = API)
public class StockController {
	
	private final StockService service;
	
	
	public StockController(StockService service) {
		this.service = service;
	}

	@Operation(summary = "Fetches the stock details")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Stock details has been fetched Successfully")})
	@GetMapping(GET_STOCKS_ENDPOINT)
	public ResponseEntity<Page<Stock>> getAllStock(@RequestParam int offset){
		return new ResponseEntity<Page<Stock>>(service.getAllStocks(offset), HttpStatus.OK);
	}
	
	@Operation(summary = "Fetches the stock details for supplied id")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Stock details has been fetched Successfully for supplied id"),
			  @ApiResponse(responseCode = "404", description = "Invalid id supplied")})
	@GetMapping(GET_STOCK_BY_ID_ENDPOINT)
	public ResponseEntity<Stock> getStockById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.getStockById(id));
	}
	
	@Operation(summary = "Creates new stock")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "201", description = "New stock is created")})
	@PostMapping(SAVE_STOCK_ENDPOINT)
	public ResponseEntity<Stock> saveStock(@RequestBody StockDTO stock){
		return new ResponseEntity<Stock>(service.save(stock), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Updates stock price for supplied id")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Stock price is updated"),
			  @ApiResponse(responseCode = "404", description = "Invalid id supplied")})
	@PatchMapping(UPDATE_STOCK_ENDPOINT)
	public ResponseEntity<Stock> updateStockById(@PathVariable("id") int id, @RequestBody StockDTO dto){
		return new ResponseEntity<Stock>(service.update(id, dto), HttpStatus.OK);
	}	
	
	@Operation(summary = "Deletes stock detail for supplied id")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Stock detail is deleted"),
			  @ApiResponse(responseCode = "404", description = "Invalid id supplied")})
	@DeleteMapping(DELETE_STOCK_BY_ID_ENDPOINT)
	public ResponseEntity<Void> deleteStockById(@PathVariable int id) {
	    service.delete(id);
	    return ResponseEntity.ok().build();
	}

}

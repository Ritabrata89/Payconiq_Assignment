package com.payconiq.assignment.stock.Service;

import org.springframework.data.domain.Page;

import com.payconiq.assignment.stock.exception.StockNotFoundException;
import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.model.StockDTO;

/**
 * The Stock service for the application.
 * @author rtbrt2009@gmail.com
 *
 */

public interface StockService {
	
	public Page<Stock> getAllStocks(int offset);
	public Stock  getStockById(int id);
	public Stock save(StockDTO stock);
	public Stock update(int id, StockDTO stock);
	public void delete(int id);
}

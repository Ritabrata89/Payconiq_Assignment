package com.payconiq.assignment.stock.Service;

import static com.payconiq.assignment.stock.exception.StockErrorDetails.STOCK_NOT_FOUND_EXCEPTION;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.payconiq.assignment.stock.exception.StockNotFoundException;
import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.model.StockDTO;
import com.payconiq.assignment.stock.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * The Stock service implementation for the application which contains the business logic.
 * @author rtbrt2009@gmail.com
 *
 */

@Slf4j
@Service
public class StockServiceImpl implements StockService{
	
	@Value("${stock.pagination.pagesize}")
	private int pageSize;
	
	private final StockRepository stockRepo;

	public StockServiceImpl(StockRepository stockRepo) {
		this.stockRepo = stockRepo;
	}

	@Override
	public Page<Stock> getAllStocks(int offset) {
		Page<Stock> paginatedStock = stockRepo.findAll(PageRequest.of(offset, pageSize));
		log.info("All stocks are fetched.");
		return paginatedStock;
	}

	@Override
	public Stock getStockById(int id){
		Stock stock = stockRepo.findById(id).orElseThrow(()-> new StockNotFoundException(STOCK_NOT_FOUND_EXCEPTION.getCode(),
				STOCK_NOT_FOUND_EXCEPTION.getStatus(),
				"Stock not found for id: "+id));
		log.info("Stock is fetched for id: "+id);
		return stock;
	}
	
	@Override
	public Stock save(StockDTO stock) {
		Stock freshStock = new Stock();
		freshStock.setName(stock.getName());
		freshStock.setCurrentPrice(stock.getCurrentPrice());
		freshStock.setLastUpdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")));
		log.info("Trying to insert a new stock.");
		return stockRepo.save(freshStock);
	}

	@Override
	public Stock update(int id, StockDTO dto){

		Stock stock = stockRepo.findById(id).orElseThrow(()-> new StockNotFoundException(STOCK_NOT_FOUND_EXCEPTION.getCode(),
				STOCK_NOT_FOUND_EXCEPTION.getStatus(),
				"Stock can not be updated for id: "+id+". It's not present."));
		stock.setCurrentPrice(dto.getCurrentPrice());
		stock.setLastUpdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")));
		log.info("Updating stock for id: "+id);
		return stockRepo.save(stock);
	}
	
	@Override
	public void delete(int id){

		log.info("Deleting stock for id: "+id);
		stockRepo.deleteById(id);
		
	}

}

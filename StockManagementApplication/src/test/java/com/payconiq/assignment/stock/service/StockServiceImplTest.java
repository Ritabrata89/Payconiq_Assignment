package com.payconiq.assignment.stock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.payconiq.assignment.stock.Service.StockService;
import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.model.StockDTO;
import com.payconiq.assignment.stock.repository.StockRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	private StockService service;
	@MockBean
	private StockRepository repo;
	
	@Test
    public void getAllStocksTest() throws Exception{  
    	int offset=1;
        Page<Stock> stockPage = repo.findAll(PageRequest.of(offset, 3));
        when(repo.findAll(PageRequest.of(offset, 3))).thenReturn(stockPage);
        assertEquals(stockPage, service.getAllStocks(offset));
      }
	
	@Test
	public void getStockByIdTest() {
		
		int id = 10;
		Stock stock = new Stock(16,"Avast",600,"2022-01-22 12:09:54 PM");
		when(repo.findById(id)).thenReturn(Optional.of(stock));
		assertEquals(stock, service.getStockById(id));	
	}
	
	@Test
	public void saveTest() {
		Stock stock = new Stock(16,"Avast",600,"2022-01-22 12:09:54 PM");
		StockDTO stockDTO = new StockDTO("Avast",600);
		when(repo.save(any())).thenReturn(stock);
		assertEquals(stock, service.save(stockDTO));
	}
	
	@Test
	public void updateTest() {
		int id = 1;
		Stock stock = new Stock(1,"Avast",600,"2022-01-22 12:09:54 PM");
		StockDTO stockDTO = new StockDTO("Avast",600);
		when(repo.findById(id)).thenReturn(Optional.of(stock));
		when(repo.save(stock)).thenReturn(stock);
		assertEquals(stock, service.update(id,stockDTO));
	}
	
	@Test
	public void deleteTest() {
		int id = 1;
		Stock stock = new Stock(16,"Avast",600,"2022-01-22 12:09:54 PM");
		when(repo.findById(id)).thenReturn(Optional.of(stock));
		service.delete(id);
		verify(repo,times(1)).deleteById(id);
	}
}

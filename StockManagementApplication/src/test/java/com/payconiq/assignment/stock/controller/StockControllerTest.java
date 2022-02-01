package com.payconiq.assignment.stock.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payconiq.assignment.stock.Service.StockService;
import com.payconiq.assignment.stock.exception.StockNotFoundException;
import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.model.StockDTO;

/**
 * The test class for Stock controller for the application.
 * @author rtbrt2009@gmail.com
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StockService service;
	
	@Test
    public void getAllStocksTest() throws Exception{  
    	int offset=1;
        Page<Stock> stockPage = service.getAllStocks(offset);
        when(service.getAllStocks(offset)).thenReturn(stockPage);
        mvc.perform(get("/api/stocks/{offset}",1))
      	      .andExpect(status().isOk());
      }
	
	@Test
	public void getById_whenStockFound_thenOK() throws Exception {
		

	    mvc.perform(get("/api/stocks/{id}", 1))
	      .andExpect(status().isOk());
	}
	
	@Test
	public void getById_whenStockNotFound_thenException() throws Exception {
		
		when(service.getStockById(11)).thenThrow(new StockNotFoundException("", HttpStatus.NOT_FOUND, ""));
	    mvc.perform(get("/api/stocks/{id}", 11))	      
	      .andExpect(status().isNotFound());
	}
	
	@Test
	public void saveTest_success() throws Exception {
		
		StockDTO stockDto = new StockDTO();
        given(service.save(stockDto)).willReturn(new Stock());
        mvc.perform(post("/api/stocks")
        		  .contentType(MediaType.APPLICATION_JSON)
				  .content(asJsonString(new StockDTO("", 400))))
			      .andExpect(status().isCreated());
	}
	
	@Test
	public void saveTest_failure() throws Exception {
		this.mvc
        .perform(post("/api/stocks"))
        .andExpect(status().is(400));

	}
	
	@Test
	public void updateStockById_whenStockFound_thenOK() throws Exception {
		
		StockDTO stockDto = new StockDTO();
        given(service.save(stockDto)).willReturn(new Stock());
        mvc.perform(patch("/api/stocks/{id}",1)
        		  .contentType(MediaType.APPLICATION_JSON)
				  .content(asJsonString(new StockDTO("", 400))))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void updateStockById_whenStockNotFound_thenError() throws Exception {
		this.mvc
        .perform(patch("/api/stocks/{id}",1))
        .andExpect(status().is(400));

	}
	
	@Test
	public void deleteStockById_whenStockFound_thenOK() throws Exception {
		mvc.perform(delete("/api/stocks/{id}", 1))
	      .andExpect(status().isOk());
	}
	
	@Test
	public void deleteStockById_whenStockNotFound_thenError() throws Exception {
		mvc.perform(delete("/api/stocks/{id}",""))
	      .andExpect(status().is(405));
	}
	
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

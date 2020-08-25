package com.dowjones.stock.index;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dowjones.stock.index.controller.StocksController;
import com.dowjones.stock.index.exception.DBException.InvalidParam;
import com.dowjones.stock.index.exception.DBException.StockException;
import com.dowjones.stock.index.exception.RecordNotFoundException;
import com.dowjones.stock.index.model.Stocks;
import com.dowjones.stock.index.service.StocksService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StockIndexApplicationTests {

	@InjectMocks
	StocksController controller;
	
	@Mock
	StocksService stocksService;

	@Test
	public void testPostStock() throws StockException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Stocks stock = new Stocks(3, "PQRS","12/12/2019","$15.25", "$155.75","$11.00");
        when(stocksService.createStock(any(Stocks.class))).thenReturn(stock);
        ResponseEntity<Stocks> responseEntity = controller.postStock(stock);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getStock().equals("PQRS"));
	}

	@Test
	public void testGetAllStocks() throws RecordNotFoundException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        List<Stocks> stocks = loadStockData();
        
        when(stocksService.getAllStockIndexes()).thenReturn(stocks);
        ResponseEntity<List<Stocks>> responseEntity = controller.getAllStocks();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertTrue(responseEntity.getBody().size()==5);
	}
	
	@Test
	public void testGetStocksById() throws InvalidParam {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        List<Stocks> stock = loadStockData();
        
        List<Stocks> stockABC = new ArrayList<Stocks>();
        stockABC.add(stock.get(0));
		when(stocksService.getStocksById("ABC")).thenReturn(stockABC);
		ResponseEntity<List<Stocks>> responseEntity = controller.getStocks("ABC");
		assertThat(responseEntity.getBody().get(0).getStock()).isEqualTo(stock.get(0).getStock());
		 
	}

	private List<Stocks> loadStockData() {
		List<Stocks> stockList = new ArrayList<>();
        Stocks stock1 = new Stocks(3, "ABC","1/12/2019","$1.25", "$15.75","$1.00");
        Stocks stock2 = new Stocks(3, "DEF","6/12/2019","$2.25", "$17.75","$1.00");
        Stocks stock3 = new Stocks(3, "GHI","18/12/2019","$3.25", "$75.75","$1.00");
        Stocks stock4 = new Stocks(3, "KLM","21/12/2019","$5.25", "$79.75","$1.00");
        Stocks stock5 = new Stocks(3, "OPQ","22/12/2019","$5.25", "$88.75","$1.00");
        stockList.add(stock1);
        stockList.add(stock2);
        stockList.add(stock3);
        stockList.add(stock4);
        stockList.add(stock5);
		return stockList;
	}
}

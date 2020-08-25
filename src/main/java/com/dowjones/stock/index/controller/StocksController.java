package com.dowjones.stock.index.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dowjones.stock.index.exception.DBException;
import com.dowjones.stock.index.exception.DBException.InvalidParam;
import com.dowjones.stock.index.exception.DBException.StockException;
import com.dowjones.stock.index.exception.RecordNotFoundException;
import com.dowjones.stock.index.model.Stocks;
import com.dowjones.stock.index.service.StocksService;

@ControllerAdvice
@RestController
@RequestMapping("/stockIndexes")
public class StocksController {

	Logger logger = LoggerFactory.getLogger(StocksController.class);

	@Autowired
	StocksService stockService;

	@GetMapping
	public ResponseEntity<List<Stocks>> getAllStocks() {
		List<Stocks> list = new ArrayList<>();
		try {
			list = stockService.getAllStockIndexes();
		} catch (Exception e) {
			if(list.isEmpty()) {
				logger.error("Error fetching all stocks.");
				throw new RecordNotFoundException("No stock indexes found.");
			}
		}
		return new ResponseEntity<List<Stocks>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(path = "/{stockId}")
	public ResponseEntity<List<Stocks>> getStocks(@PathVariable("stockId") String id) throws InvalidParam  {
		List<Stocks> list;
		try {
			list = stockService.getStocksById(id);
		} catch (Exception e) {
			logger.error("Error fetching stocks with ID:"+id);
			throw new DBException.InvalidParam("Unable to fetch stocks with provided parameter: "+id);
		}
		return new ResponseEntity<List<Stocks>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Stocks> postStock(@RequestBody Stocks stocks) throws StockException {
		Stocks st;
		try {
			st = stockService.createStock(stocks);
		} catch (Exception e) {
			logger.error("Error creating new stock.");
			throw new DBException.StockException(" Error creating a new Stock." +stocks.getStock());
		}
		return new ResponseEntity<Stocks>(st, new HttpHeaders(), HttpStatus.OK);
	}
}

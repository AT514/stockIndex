package com.dowjones.stock.index.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowjones.stock.index.exception.DBException;
import com.dowjones.stock.index.exception.RecordNotFoundException;
import com.dowjones.stock.index.model.Stocks;
import com.dowjones.stock.index.repository.StocksRepository;

@Service
public class StocksService {
	
	Logger logger = LoggerFactory.getLogger(StocksService.class);
	
	@Autowired
	StocksRepository stocksRepository;

	public List<Stocks> getAllStockIndexes() throws RecordNotFoundException{
		
		List<Stocks> stockIndexes = stocksRepository.findAll();

		if (stockIndexes.size() > 0) {
			logger.info("Fetching stocks list of count: "+stockIndexes.size());
			return stockIndexes;
		} else {
			logger.info("No record found. Returning an empty list. ");
			return new ArrayList<Stocks>();
		}
	}


	public List<Stocks> getStocksById(String id) throws RecordNotFoundException {
		List<Stocks> stocksById= stocksRepository.findStocksById(id);
		logger.info(" Fetching stocks list of size: " +stocksById.size()+ " with Id parameter "+id);
		return stocksById;
	}


	public Stocks createStock(Stocks stocks) throws DBException.StockException {
		stocks.setStock(stocks.getStock() == null ? "" : stocks.getStock());
		stocks = stocksRepository.save(stocks);
		return stocks;

	}
	
}

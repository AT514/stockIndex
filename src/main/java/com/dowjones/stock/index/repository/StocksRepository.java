package com.dowjones.stock.index.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dowjones.stock.index.model.Stocks;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, String> {
	 
	    @Query("SELECT st FROM Stocks st WHERE LOWER(st.stock) = LOWER(:stockId)")
	    public List<Stocks> findStocksById(@Param("stockId") String stockId);
	    
	    //<S> void save(Stocks stocks);
}

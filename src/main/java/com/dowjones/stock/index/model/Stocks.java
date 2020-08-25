package com.dowjones.stock.index.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOW_JONES_INDEX")
public class Stocks {

	@Column(name="quarter")
	private int quarter;
	
	@Column(name="stock")
	@Id
	private String stock;
	
	@Column(name="date")
	private String date;
	
	@Column(name="open")
	private String open;
	
	@Column(name="high")
	private String high;
	
	@Column(name="low")
	private String low;
	
	@Column(name="close")
	private String close;
	
	@Column(name="volume")
	private Long volume;
	
	@Column(name="percent_change_price")
	private BigDecimal percent_change_price;
	
	@Column(name="percent_change_volume_over_last_wk")
	private BigDecimal percent_change_volume_over_last_wk;
	
	@Column(name="previous_weeks_volume")
	private Long previous_weeks_volume;
	
	@Column(name="next_weeks_open")
	private String next_weeks_open;
	
	@Column(name="next_weeks_close")
	private String next_weeks_close;
	
	@Column(name="percent_change_next_weeks_price")
	private BigDecimal percent_change_next_weeks_price;
	
	@Column(name="days_to_next_dividend")
	private Long days_to_next_dividend;
	
	@Column(name="percent_return_next_dividend")
	private BigDecimal percent_return_next_dividend;

	public Stocks() {
		
	}
	public Stocks(String stock) {
		this.stock = stock;
	}

	public Stocks(int quarter, String stock, String date, String open, String high, String low) {
		super();
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public BigDecimal getPercent_change_price() {
		return percent_change_price;
	}

	public void setPercent_change_price(BigDecimal percent_change_price) {
		this.percent_change_price = percent_change_price;
	}

	public BigDecimal getPercent_change_volume_over_last_wk() {
		return percent_change_volume_over_last_wk;
	}

	public void setPercent_change_volume_over_last_wk(BigDecimal percent_change_volume_over_last_wk) {
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
	}

	public Long getPrevious_weeks_volume() {
		return previous_weeks_volume;
	}

	public void setPrevious_weeks_volume(Long previous_weeks_volume) {
		this.previous_weeks_volume = previous_weeks_volume;
	}

	public String getNext_weeks_open() {
		return next_weeks_open;
	}

	public void setNext_weeks_open(String next_weeks_open) {
		this.next_weeks_open = next_weeks_open;
	}

	public String getNext_weeks_close() {
		return next_weeks_close;
	}

	public void setNext_weeks_close(String next_weeks_close) {
		this.next_weeks_close = next_weeks_close;
	}

	public BigDecimal getPercent_change_next_weeks_price() {
		return percent_change_next_weeks_price;
	}

	public void setPercent_change_next_weeks_price(BigDecimal percent_change_next_weeks_price) {
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
	}

	public Long getDays_to_next_dividend() {
		return days_to_next_dividend;
	}

	public void setDays_to_next_dividend(Long days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}

	public BigDecimal getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}

	public void setPercent_return_next_dividend(BigDecimal percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}

}

package com.dowjones.stock.index.exception;

public abstract class BaseException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
 
    public BaseException(String msg)
    {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}

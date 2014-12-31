package cn.lfy.common.framework.exception;

import cn.lfy.common.utils.Constants;

public class ServiceException extends Exception{

	
	private static final long serialVersionUID = 407336058864344636L;

	private Integer code;
	
	private Integer statusCode;
	
	private String message;
	
	private Exception exception;
	
	public ServiceException(){
		super();
	}
	
	public ServiceException(Integer _code, Integer _statusCode, String _message){
		this.code = _code;
		this.statusCode = _statusCode;
		this.message = _message;
	}
	
	public ServiceException(Integer _code, Integer _statusCode, String _message, Exception _exception){
		this.code = _code;
		this.statusCode = _statusCode;
		this.message = _message;
		this.exception = _exception;
	}
	
	public ServiceException(Constants enums){
		this.code = enums.getCode();
		this.statusCode = enums.getStatusCode();
		this.message = enums.getMessage();
	}
	
	public ServiceException(Constants enums, Exception _exception){
		this.code = enums.getCode();
		this.statusCode = enums.getStatusCode();
		this.message = enums.getMessage();
		this.exception = _exception;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

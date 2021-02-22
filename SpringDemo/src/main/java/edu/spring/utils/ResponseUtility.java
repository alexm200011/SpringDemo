package edu.spring.utils;

import java.io.Serializable;

public class ResponseUtility implements Serializable  {
		
	private static final long serialVersionUID = 1L;
	
	private String message;	
	private Object content;
	
	public ResponseUtility(String message, Object content) {
		super();
		this.message = message;		
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}

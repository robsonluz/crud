package edu.fae.crud.model;

public class Message {
	private String status;
	public static final Message OK = new Message("OK");

	public Message() {
	}

	public Message(String status) {
		this.status = status;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

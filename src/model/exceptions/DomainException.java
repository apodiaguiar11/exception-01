package model.exceptions;

public class DomainException extends Exception {
	
	private static final long serialVersionUID = 1L;//Determinando a version

	public DomainException(String msg) {
		super(msg);
	}
}

package co.edu.udea.proyectointegrador.exception;

import org.apache.log4j.Logger;

public class AlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(AlreadyExistsException.class);

	public AlreadyExistsException() {
		super();
		log.error(this.getMessage(), this);
	}

	public AlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		log.error(arg0, arg1);
	}

	public AlreadyExistsException(String arg0) {
		super(arg0);
		log.error(arg0, this);
	}

	public AlreadyExistsException(Throwable arg0) {
		super(arg0);
		log.error(arg0.getMessage(), arg0);
	}

	
}

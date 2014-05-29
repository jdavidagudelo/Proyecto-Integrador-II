package co.edu.udea.proyectointegrador.exception;

import org.apache.log4j.Logger;

/**
 * Esta clase es utilizada para manejar excepciones causadas por el acceso a los
 * datos.
 * 
 * @author Juan David Agudelo Alvarez jdaaa2009@gmail.com
 * @version 1
 * */
public class DaoException extends Exception {
	Logger log = Logger.getLogger(DaoException.class);

	public DaoException() {
		super();
		log.error(this.getMessage(), this);
		
	}

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		log.error(arg0, arg1);
	}

	public DaoException(String arg0) {
		super(arg0);
		log.error(arg0, this);
	}

	public DaoException(Throwable arg0) {
		super(arg0);
		log.error(arg0.getMessage(), arg0);
	}

	private static final long serialVersionUID = 1L;

}

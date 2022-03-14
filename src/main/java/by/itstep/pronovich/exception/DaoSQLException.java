package by.itstep.pronovich.exception;

public class DaoSQLException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9104515699486850300L;

	public DaoSQLException() {
		super();
	}

	public DaoSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoSQLException(String message) {
		super(message);
	}

	public DaoSQLException(Throwable cause) {
		super(cause);
	}


}

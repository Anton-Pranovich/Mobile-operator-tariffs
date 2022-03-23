package by.itstep.pronovich.exception;

public class AddException extends RuntimeException {

	private static final long serialVersionUID = -364462486249130521L;

	public AddException() {
		super();
	}

	public AddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddException(String message) {
		super(message);
	}

	public AddException(Throwable cause) {
		super(cause);
	}

}

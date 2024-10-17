package view.tree.error;

public class MyError {
	private String message;
	private int errorType;
	
	
	public MyError(String message, int errorType) {
		super();
		this.message = message;
		this.errorType = errorType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorType() {
		return errorType;
	}
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}
	
	

}

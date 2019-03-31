package my.di.core;

public class DuplicateBeanException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateBeanException(Class<?> clazz) {
		super(clazz.getName());
	}
	

}

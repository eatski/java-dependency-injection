package my.di.core;

public interface ApplicationContext {
	
	public <T> T getBean(Class<T> clazz);
	public <T> T getBean(Class<T> clazz,String specify);

}


package my.di.core;

public abstract class CirculationRejectableBeanFactory<T> implements BeanFactory<T>{
	
	private boolean resolving;
	private T stock = null;
	
	@Override
	public T get() {
		if(resolving) {
			throw new RuntimeException("再帰");
		}
		if(stock == null) {
			resolving = true;
			stock = getBean();
			resolving = false;
		}
		return stock;
	}
	
	protected abstract T getBean();

}

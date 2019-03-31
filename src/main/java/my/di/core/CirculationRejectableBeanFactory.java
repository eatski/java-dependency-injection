
package my.di.core;

import my.di.core.exception.CircularRequireException;

public abstract class CirculationRejectableBeanFactory<T> implements BeanFactory<T>{
	
	private boolean resolving;
	private T stock = null;
	
	@Override
	public T get() {
		if(resolving) {
			throw new CircularRequireException();
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

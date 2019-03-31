package my.di.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Supplier;

import my.di.core.annotation.Qualifier;


public class MethodBeanFactory<T> extends CirculationRejectableBeanFactory<T>{

	private Supplier<T> sup;
	
	public MethodBeanFactory(Method method,Object config,Class<T> clazz ,ApplicationContext context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		this.sup = () -> {
			Object[] args = Arrays.stream(method.getParameters())
					.map(param->
						param.isAnnotationPresent(Qualifier.class) ? 
						context.getBean(param.getType(),param.getAnnotation(Qualifier.class).value()) :
						context.getBean(param.getType())
					)
					.toArray();
			try {
				return clazz.cast(method.invoke(config,args)) ;
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			
		};
		
	}

	@Override
	protected T getBean() {
		// TODO Auto-generated method stub
		return sup.get();
	}

}

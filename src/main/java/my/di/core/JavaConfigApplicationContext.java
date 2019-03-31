package my.di.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import my.di.core.annotation.Bean;
import my.di.core.container.BeanFactoryDictionary;
import my.di.core.exception.DuplicateBeanException;

public class JavaConfigApplicationContext implements ApplicationContext{
	
	private BeanFactoryDictionary factories = new BeanFactoryDictionary();
	
	public JavaConfigApplicationContext(Class<?> root) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Object rootObj = root.getConstructor().newInstance();
		
		for(Method m : root.getMethods()) {
			if(m.isAnnotationPresent(Bean.class)) {
				putToDict(m.getReturnType(),m,rootObj);
			}
		}
	}

	@Override
	public <T> T getBean(Class<T> clazz) {
		
		return getBean(factories.get(clazz),clazz);
		
	}

	@Override
	public <T> T getBean(Class<T> clazz, String specify) {
		return getBean(factories.get(clazz,specify),clazz);
	}
	
	private <T> T getBean(List<BeanFactory<T>> list,Class<T> clazz) {
		if(list.size() == 1) {
			return list.get(0).get();
		}
		throw new DuplicateBeanException(clazz);
		
	}
	
	private <T> void putToDict(Class<T> returnType,Method method,Object rootObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String name = method.getAnnotation(Bean.class).value();
		factories.put(returnType, name,new MethodBeanFactory<T>(method, rootObj, returnType, this));
	}

}

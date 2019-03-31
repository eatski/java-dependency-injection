package my.di.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactoryDictionary {
	
	private Map<Class<?>,BeanFactoryDictionaryOnClass<?>> container = new HashMap<>();
	
	
	@SuppressWarnings("unchecked")
	public <T> void put(Class<T> clazz,String name,BeanFactory<T> factory) {
		
		if(!container.containsKey(clazz)) {
			container.put(clazz, new BeanFactoryDictionaryOnClass<>());
		}
		BeanFactoryDictionaryOnClass<T> containerOnClass = (BeanFactoryDictionaryOnClass<T>)container.get(clazz);
		
		containerOnClass.add(name,factory);
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<BeanFactory<T>> get(Class<T> clazz,String name){
		BeanFactoryDictionaryOnClass<T> onClass = (BeanFactoryDictionaryOnClass<T>) container.get(clazz);
		return onClass.get(name);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<BeanFactory<T>> get(Class<T> clazz){
		BeanFactoryDictionaryOnClass<T> onClass = (BeanFactoryDictionaryOnClass<T>) container.get(clazz);
		return onClass.get();
	}
	


}

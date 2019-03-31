package my.di.core.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import my.di.core.BeanFactory;

public class BeanFactoryDictionaryOnClass<T> {

	private Map<String,List<BeanFactory<T>>> container = new HashMap<>();
	
	public List<BeanFactory<T>> get(String name) {
		return container.get(name);
	}
	
	public List<BeanFactory<T>> get() {
		Function<Entry<String,List<BeanFactory<T>>>,Stream<BeanFactory<T>>> entry2stream = e -> e.getValue().stream();
		return container.entrySet()
				.stream()
				.collect(Collectors.flatMapping(entry2stream, Collectors.toList()));
	}
	
	public void add(String name,BeanFactory<T> factory) {
		if(!container.containsKey(name)) {
			container.put(name, new ArrayList<>());
		}
		container.get(name).add(factory);
	}

}

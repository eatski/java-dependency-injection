package my.di.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class MethodBeanFactoryTest {
	
	@Test
	public void test1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Hoge1 hoge1 = new Hoge1();
		ApplicationContext mock = mock(ApplicationContext.class);
		when(mock.getBean(Hoge1.class)).thenReturn(hoge1);
		MethodBeanFactory<Hoge2> factory = new MethodBeanFactory<>(
				ConfigStub.class.getDeclaredMethod("hoge2", Hoge1.class),
				new ConfigStub(), Hoge2.class, mock);
		
		assertThat(factory.get().getHoge1()).isEqualTo(hoge1);
	}

}

package my.di.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import my.di.core.stub.Hoge1;
import my.di.core.stub.Hoge2;
import my.di.core.stub.正常系Stub;

public class MethodBeanFactoryTest {
	
	@Test
	public void test1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Hoge1 hoge1 = new Hoge1();
		ApplicationContext mock = mock(ApplicationContext.class);
		when(mock.getBean(Hoge1.class)).thenReturn(hoge1);
		MethodBeanFactory<Hoge2> factory = new MethodBeanFactory<>(
				正常系Stub.class.getDeclaredMethod("hoge2", Hoge1.class),
				new 正常系Stub(), Hoge2.class, mock);
		
		assertThat(factory.get().getHoge1()).isEqualTo(hoge1);
	}

}

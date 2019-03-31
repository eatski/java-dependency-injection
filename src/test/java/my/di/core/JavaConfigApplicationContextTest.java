package my.di.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class JavaConfigApplicationContextTest {
	
	@Test
	public void test1() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext  context = new JavaConfigApplicationContext(ConfigStub.class);
		assertThat(context.getBean(Hoge2.class).getHoge1())
			.isEqualTo(context.getBean(Hoge1.class));
	}
	
	@Test
	public void test2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext  context = new JavaConfigApplicationContext(ConfigStub2.class);
		try {
			context.getBean(Hoge2.class);
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage()).isEqualTo("再帰");
		}
	}
	
	@Test
	public void test3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext  context = new JavaConfigApplicationContext(ConfigStub3.class);
		assertThat(context.getBean(Hoge2.class).getHoge1())
			.isEqualTo(context.getBean(Hoge1.class,"a"));
	}
	
	

}

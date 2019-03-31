package my.di.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import my.di.core.exception.CircularRequireException;
import my.di.core.stub.Hoge1;
import my.di.core.stub.Hoge2;
import my.di.core.stub.正常系Stub;
import my.di.core.stub.正常系命名指定Stub;
import my.di.core.stub.異常系循環参照Stub;

public class JavaConfigApplicationContextTest {
	
	@Test
	public void 正常系_Beanが返却される() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext  context = new JavaConfigApplicationContext(正常系Stub.class);
		assertThat(context.getBean(Hoge2.class).getHoge1())
			.isEqualTo(context.getBean(Hoge1.class));
	}
	
	@Test
	public void 異常系_循環参照の場合に例外を投げる() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext  context = new JavaConfigApplicationContext(異常系循環参照Stub.class);
		try {
			context.getBean(Hoge2.class);
			fail();
		} catch (CircularRequireException e) {
		}
	}
	
	@Test
	public void 正常系_Qualifierで指定したBeanが返却される() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext  context = new JavaConfigApplicationContext(正常系命名指定Stub.class);
		assertThat(context.getBean(Hoge2.class).getHoge1())
			.isEqualTo(context.getBean(Hoge1.class,"a"));
	}
	
	

}

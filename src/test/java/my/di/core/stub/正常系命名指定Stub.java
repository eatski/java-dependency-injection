package my.di.core.stub;

import my.di.core.annotation.Bean;
import my.di.core.annotation.Qualifier;

public class 正常系命名指定Stub {
	
	
	@Bean("a")
	public Hoge1 hoge1a() {
		Hoge1 hoge1 = new Hoge1();
		return hoge1;
	}
	
	@Bean("b")
	public Hoge1 hoge1b() {
		Hoge1 hoge1 = new Hoge1();
		return hoge1;
	}
	
	@Bean
	public Hoge2 hoge2(@Qualifier("a") Hoge1  hoge1) {
		return new Hoge2(hoge1);
	}
	
	

}

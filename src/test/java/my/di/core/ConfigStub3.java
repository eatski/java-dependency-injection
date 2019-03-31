package my.di.core;

import my.di.core.annotation.Bean;
import my.di.core.annotation.Qualifier;

public class ConfigStub3 {
	
	
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
